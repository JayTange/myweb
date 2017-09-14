package org.seckill.service.impl;

import org.seckill.dao.RedisDao;
import org.seckill.dao.SecKillDao;
import org.seckill.dao.SuccessKilledDao;
import org.seckill.dto.Exposer;
import org.seckill.dto.SeckillExcution;
import org.seckill.entity.SecKill;
import org.seckill.entity.SuccessKilled;
import org.seckill.enums.SeckillStatEnum;
import org.seckill.exception.RepeatKillException;
import org.seckill.exception.SeckillCloseException;
import org.seckill.exception.SeckillException;
import org.seckill.service.SecKillService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.DigestUtils;

import java.util.Date;
import java.util.List;
@Service
@SuppressWarnings("SpringJavaAutowiringInspection")
public class SeckillServiceImpl implements SecKillService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    // 用于mds
    private final String slat = "dfjhqjierhoqjhrjklqwerio21u3io4u$%%&&&^%$";

    //注入依赖
    @Autowired
    private  SecKillDao secKillDao;

    @Autowired
    private SuccessKilledDao successKilledDao;

    @Autowired
    private RedisDao redisDao;

    public List<SecKill> getSeckilList() {
        return secKillDao.queryAll(0, 4);
    }

    public SecKill getById(long seckillId) {
        return secKillDao.queryById(seckillId);
    }

    public Exposer exportSeckillUrl(long seckillId) {

        //秒杀优化点,通过redis缓存, 超时的基础上维护一致性
        //1:访问redis
        SecKill secKill = redisDao.getSecKill(seckillId);
        if(secKill == null){
            //2:访问数据库
            secKill = secKillDao.queryById(seckillId);
            if(secKill == null){
                return new Exposer(false,seckillId);
            }else {
                //3:放入redis
                redisDao.putSeckill(secKill);
            }
        }

        if (secKill == null) {
            return new Exposer(false, seckillId);
        }

        Date startTime = secKill.getStartTime();
        Date endTime = secKill.getEndTime();

        Date nowTime = new Date();

        if (nowTime.getTime() < startTime.getTime() || nowTime.getTime() > endTime.getTime()) {
            return new Exposer(false, seckillId, nowTime.getTime(), startTime.getTime(), endTime.getTime());
        }

        String mds = getMd5(seckillId);

        return new Exposer(true, mds, seckillId);
    }

    private String getMd5(long seckillId) {
        String base = seckillId + "/" + slat;
        String md5 = DigestUtils.md5DigestAsHex(base.getBytes());
        return md5;
    }


    @Override
    @Transactional
    /**
     * 使用注解完成事务方法的有点
     * 保证事务执行时间尽可能端，不要穿插网络操作http、tcp,(玻璃到方法外面)
     * 不是所有的方法都需要事务，如只需要插入一跳数据
     */
    public SeckillExcution executeSeckill(long seckillId, long userPhone, String md5) throws SeckillException, RepeatKillException, SeckillCloseException {
        if (md5 == null || !md5.equals(getMd5(seckillId))) {
            throw new SeckillException("seckill data rewrite");
        }
        //执行秒杀逻辑,减库存和记录秒杀行为
        Date nowTime = new Date();
        try {
            int updateCount = secKillDao.reduceNumber(seckillId, nowTime);
            if (updateCount <= 0) {
                //没有更新到记录,秒杀结束
                throw new SeckillCloseException("seckill is closed");
            } else {
                //记录购买行为
                int insertCount = successKilledDao.insertSuccessKill(seckillId, userPhone);
                // 唯一的id和phone
                if (insertCount <= 0) {
                    // 重复秒杀
                    throw new RepeatKillException("seckill repeat");
                } else {
                    // 秒杀成功
                    SuccessKilled successKilled = successKilledDao.queryByIdWithSecKill(seckillId, userPhone);
                    return new SeckillExcution(seckillId, SeckillStatEnum.SUCCESS, successKilled);
                }
            }
        } catch (SeckillCloseException e1) {
            throw e1;
        } catch (RepeatKillException e2) {
            throw e2;
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            throw new SeckillException("seckill inner error" + e.getMessage());
        }

    }
}

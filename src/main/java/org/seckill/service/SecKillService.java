package org.seckill.service;

import org.seckill.dto.Exposer;
import org.seckill.dto.SeckillExcution;
import org.seckill.entity.SecKill;
import org.seckill.exception.RepeatKillException;
import org.seckill.exception.SeckillCloseException;
import org.seckill.exception.SeckillException;

import java.util.List;

/**
 * 业务接口：站在"使用者角度"涉及接口
 * 三个方面：1.方法定义粒度，2参数 3返回类型
 */
public interface SecKillService {

    /**
     * 查询所有秒杀记录
     *
     * @return
     */
    List<SecKill> getSeckilList();

    /**
     * 查询单个秒杀记录
     *
     * @param seckillId
     * @return
     */
    SecKill getById(long seckillId);

    /**
     * 秒杀开启时输出秒杀接口地址（房子地址固定，插件进行秒杀）
     * 否则输出系统时间和秒杀时间
     *
     * @param seckillId
     */
    Exposer exportSeckillUrl(long seckillId);

    /**
     * 执行秒杀操作
     *
     * @param seckillId
     * @param userPhone
     * @param md5
     */
    SeckillExcution executeSeckill(long seckillId, long userPhone, String md5)
        throws SeckillException, RepeatKillException, SeckillCloseException;
}

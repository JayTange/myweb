package org.seckill.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.seckill.dto.Exposer;
import org.seckill.dto.SeckillExcution;
import org.seckill.entity.SecKill;
import org.seckill.exception.RepeatKillException;
import org.seckill.exception.SeckillCloseException;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-dao.xml",
"classpath:spring/spring-service.xml"})
public class SecKillServiceTest {

    private final org.slf4j.Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private SecKillService secKillService;
    @Test
    public void getSeckilList() throws Exception {
        List<SecKill>list = secKillService.getSeckilList();
        logger.info("list={}",list);
    }

    @Test
    public void getById() throws Exception {
        long id = 1000;
        SecKill secKill = secKillService.getById(id);
        logger.info("seckill={}",secKill);
    }

    @Test
    public void exportSeckillUrl() throws Exception {
        long id = 1001;
        Exposer exposer = secKillService.exportSeckillUrl(id);
        if (exposer.isExposed()){
            try{
                long phone =1090191029;
                String md5 = exposer.getMd5();
                SeckillExcution seckillExcution = secKillService.executeSeckill(id,phone,md5);
                logger.info("seckillExcution:{}",seckillExcution);
                logger.info("seckillExcution:{}",seckillExcution);
            }catch (SeckillCloseException e1){
                logger.error(e1.getMessage());
            }catch (RepeatKillException e2){
                logger.error(e2.getMessage());
            }
            logger.info("exposer={}",exposer);
        }else {
            // 秒杀未开启
            logger.warn("exposer={}",exposer);
        }

    }

}
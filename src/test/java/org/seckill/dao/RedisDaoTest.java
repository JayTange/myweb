package org.seckill.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.seckill.entity.SecKill;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/spring-dao.xml")
public class RedisDaoTest {
    private long id = 1001;
    @Autowired
    private RedisDao redisDao;

    @Autowired
    private SecKillDao secKillDao;
    @Test
    public void testSecKill() throws Exception {
        SecKill secKill = redisDao.getSecKill(id);
        if(secKill ==null){
            secKill = secKillDao.queryById(id);
            if(secKill!=null){
                String result = redisDao.putSeckill(secKill);
                System.out.println("第一次存入REDIS");
                System.out.println(result);
                secKill = redisDao.getSecKill(id);
                System.out.println(secKill);
            }
        }
    }

    @Test
    public void testgetredis()throws  Exception{
        SecKill secKill = null;
        System.out.println("从redis中取出");
        secKill = redisDao.getSecKill(1001);
        System.out.println(secKill);
    }

}
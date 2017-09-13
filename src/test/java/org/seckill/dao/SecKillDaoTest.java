package org.seckill.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.seckill.entity.SecKill;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

/**
 * 配置spring和junit的依赖，junit启动时，加载springIOC容器
 */
@RunWith(SpringJUnit4ClassRunner.class)
// 告诉junit spring配置文件
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
@SuppressWarnings("SpringJavaAutowiringInspection")
public class SecKillDaoTest {

    // 注入Dao实现类依赖
    @Resource
    private SecKillDao secKillDao;

    @Test
    public void queryById() throws Exception {
        long id = 1000;
        SecKill secKill = secKillDao.queryById(id);
        System.err.println(secKill.getName());
        System.err.println(secKill);
    }


    @Test
    public void reduceNumber() throws Exception {
        Date killTime = new Date();
        int updateCount = secKillDao.reduceNumber(1000L,killTime);
        System.out.println(updateCount);

    }


    @Test
    public void queryAll() throws Exception {
        List<SecKill> secKills = secKillDao.queryAll(0,100);
        for(SecKill secKill:secKills){
            System.out.println(secKill);
        }
    }

}
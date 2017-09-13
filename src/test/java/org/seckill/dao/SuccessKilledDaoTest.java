package org.seckill.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.seckill.entity.SuccessKilled;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import static org.junit.Assert.*;
/**
 * 配置spring和junit的依赖，junit启动时，加载springIOC容器
 */
@RunWith(SpringJUnit4ClassRunner.class)
// 告诉junit spring配置文件
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
@SuppressWarnings("SpringJavaAutowiringInspection")
public class SuccessKilledDaoTest {

    @Resource
    private SuccessKilledDao successKillDao;

    @Test
    public void insertSuccessKill() throws Exception {
        long id =1000L;
        long phone = 13878787878L;
        int insertCount = successKillDao.insertSuccessKill(id,phone);
        System.out.println(insertCount);
    }

    @Test
    public void queryByIdWithSecKill() throws Exception {
        long id = 1000L;
        long phone = 13878787878L;
        SuccessKilled successKilled = successKillDao.queryByIdWithSecKill(id,phone);
        System.out.println(successKilled);
        System.out.println(successKilled.getSecKill());
    }

}
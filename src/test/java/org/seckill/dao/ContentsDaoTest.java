package org.seckill.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.seckill.entity.Contents;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import java.util.List;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
// 告诉junit spring配置文件
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
@SuppressWarnings("SpringJavaAutowiringInspection")
public class ContentsDaoTest {
    @Resource
    private ContentsDao contentsDao;
    @Test
    public void queryAll() throws Exception {
        List<Contents>list = contentsDao.queryAll(10,20);
        for(Contents contents:list){
            System.out.println(contents);
        }
    }

}
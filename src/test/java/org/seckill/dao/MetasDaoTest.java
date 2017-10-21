package org.seckill.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.seckill.entity.Metas;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
// 告诉junit spring配置文件
@ContextConfiguration({"classpath:spring/spring-dao.xml"})
@SuppressWarnings("SpringJavaAutowiringInspection")
public class MetasDaoTest {
    @Autowired
    private MetasDao metasDao;
    @Test
    public void queryAll() throws Exception {
        String type="category";
        List<Metas> list = metasDao.queryAll(type);
        System.out.println(list);
    }
}
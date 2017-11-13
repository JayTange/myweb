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

    @Test
    public void getCount()throws Exception{
        Integer count = contentsDao.getCount();
        System.err.println("记录总数量为："+count);
    }

    @Test
    public void delete()throws  Exception{
        int cid = 1;
        contentsDao.deleteContent(cid);
    }

    @Test
    public void getSlug() throws Exception{
        String slug = "about";
        int count = contentsDao.getSlugCount(slug);
        System.err.println("slug数量为"+count);
    }

}
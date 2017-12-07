package org.seckill.dao;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.seckill.entity.Archive;
import org.seckill.entity.Contents;
import org.seckill.util.DateKit;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import java.util.Date;
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

    @Test
    public void insertContent()throws Exception{
       Contents contents = new Contents();
       contents.setTitle("测试");
       contents.setSlug("qerqewr");
       contents.setCreated(DateKit.getCurrentUnixTime());
       contents.setModified(DateKit.getCurrentUnixTime());
       contents.setContent("这是个测试");
       contents.setAuthorId(1);
       contents.setHits(0);
       contents.setType("daf");
       contents.setStatus("publish");
       contentsDao.insertContent(contents);
    }

    @Test
    public void updateByPrimaryKey()throws Exception{
        Contents contents = new Contents();
        contents.setCid(1);
        contents.setTitle("测试");
        contents.setSlug("qerqewr");
        contents.setCreated(DateKit.getCurrentUnixTime());
        contents.setModified(DateKit.getCurrentUnixTime());
        contents.setContent("这是个测试");
        contents.setAuthorId(1);
        contents.setHits(0);
        contents.setType("daf");
        contents.setStatus("publish");
        contentsDao.updateByPrimaryKey(contents);
    }

    @Test
    public void selectByPrimaryKey()throws Exception{
        int cid = 1;
        Contents contents = contentsDao.selectByPrimaryKey(cid);
        System.out.println(contents);
    }

    @Test
    public void updateByPrimaryKeyWithCondition() throws Exception{
        Contents contents = new Contents();
        contents.setCid(29);
        contents.setTitle("测试");
        contents.setSlug("qerqewr");
        contents.setCreated(DateKit.getCurrentUnixTime());
        contents.setModified(DateKit.getCurrentUnixTime());
        contents.setContent("这是个测试");
        contents.setAuthorId(1);
        contents.setHits(0);
        contents.setType("daf");
        contents.setStatus("publish");
        contentsDao.updateByPrimaryKeyWithCondition(contents);
    }

    @Test
    public void selectBySlug() throws  Exception{
        List<Contents> contents = contentsDao.selectBySlug("book");
        System.out.println(contents.size());
    }

    @Test
    public void findReturnArchive() throws  Exception{
        List<Archive> list = contentsDao.findReturnArchive();
        System.out.println(list);
    }

    @Test
    public void getContentArchive() throws Exception{
        String date = "2017年11月";
        Date sd = DateKit.dateFormat(date, "yyyy年MM月");
        int start = DateKit.getUnixTimeByDate(sd);
        int end = DateKit.getUnixTimeByDate(DateKit.dateAdd(DateKit.INTERVAL_MONTH, sd, 1)) - 1;
        List<Contents> list = contentsDao.getContentArchive(start,end);
        System.out.println(list);
    }
}
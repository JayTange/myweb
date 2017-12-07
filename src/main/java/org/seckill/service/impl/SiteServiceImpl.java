package org.seckill.service.impl;

import org.seckill.dao.ContentsDao;
import org.seckill.entity.Archive;
import org.seckill.entity.Contents;
import org.seckill.service.ISiteService;
import org.seckill.util.DateKit;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;
@Service
public class SiteServiceImpl implements ISiteService{

    @Resource
    private ContentsDao contentsDao;
    /**
     * 查询文章归档
     *
     * @return
     */
    @Override
    public List<Archive> getArchives() {
        List<Archive> archives = contentsDao.findReturnArchive();
        if (null != archives){
            for (Archive archive:archives){
                String date = archive.getDate();
                Date sd = DateKit.dateFormat(date,"yyyy年MM月");
                int start = DateKit.getUnixTimeByDate(sd);
                int end = DateKit.getUnixTimeByDate(DateKit.dateAdd(DateKit.INTERVAL_MONTH, sd, 1))-1;
                List<Contents> contentsList = contentsDao.getContentArchive(start,end);
                archive.setArticles(contentsList);
            }
        }
        return archives;
    }
}

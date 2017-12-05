package org.seckill.service.impl;

import org.seckill.dao.ContentsDao;
import org.seckill.entity.Archive;
import org.seckill.service.ISiteService;

import javax.annotation.Resource;
import java.util.List;

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

            }
        }
        return null;
    }
}

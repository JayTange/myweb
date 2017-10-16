package org.seckill.service.impl;

import org.seckill.dao.ContentsDao;
import org.seckill.entity.Contents;
import org.seckill.service.ContentsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@SuppressWarnings("SpringJavaAutowiringInspection")
public class ContentsServiceImpl implements ContentsService {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private ContentsDao contentsDao;

    @Override
    public List<Contents> getContentsList(Integer limit,Integer offest) {
        return contentsDao.queryAll(limit,offest);
    }
}

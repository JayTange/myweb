package org.seckill.service.impl;

import org.apache.commons.lang3.StringUtils;
import org.seckill.dao.ContentsDao;
import org.seckill.entity.Contents;
import org.seckill.service.ContentsService;
import org.seckill.util.Tools;
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
    public Integer getContentsCount() {
        return contentsDao.getCount();
    }

    @Override
    public List<Contents> getContentsList(Integer limit,Integer offest) {
        return contentsDao.queryAll(limit,offest);
    }

    @Override
    public void deleteContent(Integer cid) {
        contentsDao.deleteContent(cid);
    }

    @Override
    public Contents getContentByCid(String cid) {
        if (StringUtils.isNotBlank(cid)){
            if (Tools.isNumber(cid)){
//                Contents contents = contentsDao.
            }
        }
        return null;
    }

}

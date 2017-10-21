package org.seckill.service.impl;

import org.seckill.dao.MetasDao;
import org.seckill.entity.Metas;
import org.seckill.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * 文章服务实现类
 * @author tnagj
 */
public class ArticleServiceImpl implements ArticleService{

    @Autowired
    private MetasDao metasDao;

    /**
     * 返回文章的标签
     * @param type
     * @return
     */
    @Override
    public List<Metas> getArticleType(String type) {
        return metasDao.queryAll(type);
    }
}

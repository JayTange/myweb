package org.seckill.service;

import org.seckill.entity.Metas;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 文章服务
 * @author tangj
 */
public interface ArticleService {

    /**
     * 获取文章分类
     *
     * @param type
     * @return
     */
    List<Metas> getArticleType(String type);
}

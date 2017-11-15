package org.seckill.service;

import org.apache.ibatis.annotations.Param;
import org.seckill.entity.Contents;
import org.seckill.entity.Metas;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 文章服务
 *
 * @author tangj
 */
public interface ArticleService {

    /**
     * 发布文章
     *
     * @param contents
     */
    void publish(Contents contents);

    /**
     * 获取文章分类
     *
     * @param type
     * @return
     */
    List<Metas> getArticleType(String type);

    /**
     * 根据ID获取文章内容
     *
     * @param id
     * @return
     */
    Contents getContentByCid(String id);

    /**
     * 更新文章
     *
     * @param contents
     */
    void updateArticle(Contents contents);

    /**
     * 根据偏移量查询文章列表
     *
     * @param offset
     * @param limit
     * @return
     */
    List<Contents> queryAll(@Param("limit") int limit, @Param("offset") int offset);
    /**
     * 获取文章总数
     *
     * @return
     */
    Integer getContentsCount();
}

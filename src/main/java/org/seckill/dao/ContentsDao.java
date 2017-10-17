package org.seckill.dao;

import org.apache.ibatis.annotations.Param;
import org.seckill.entity.Contents;

import java.util.List;

public interface ContentsDao {

    /**
     * 根据偏移量查询文章列表
     *
     * @param offset
     * @param limit
     * @return
     */
    List<Contents> queryAll(@Param("limit") int limit, @Param("offset") int offset);


    /**
     * 查询文章记录总数
     *
     * @return
     */
    Integer getCount();

    /**
     * 删除文章
     * @param cid
     */
    void deleteContent(Integer cid);
}

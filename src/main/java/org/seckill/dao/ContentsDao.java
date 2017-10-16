package org.seckill.dao;

import org.apache.ibatis.annotations.Param;
import org.seckill.entity.Contents;

import java.util.List;

public interface ContentsDao {

    /**
     * 根据偏移量查询文章列表
     * @param offset
     * @param limit
     * @return
     */
    List<Contents> queryAll(@Param("limit") int limit, @Param("offset") int offset);

}

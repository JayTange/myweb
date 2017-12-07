package org.seckill.dao;

import org.apache.ibatis.annotations.Param;
import org.seckill.entity.Archive;
import org.seckill.entity.Contents;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
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
     *
     * @param cid
     */
    void deleteContent(Integer cid);

    /**
     * 根据路径获取文章数
     *
     * @param slug
     * @return
     */
    Integer getSlugCount(String slug);

    /**
     * 插入一篇文章
     *
     * @param contents
     * @return
     */
    int insertContent(Contents contents);

    /**
     * 根据cid获取文章内容
     *
     * @param contents
     * @return
     */
    int updateByPrimaryKey(Contents contents);

    /**
     * 根据cid获取文章
     *
     * @param cid
     * @return
     */
    Contents selectByPrimaryKey(int cid);

    /**
     * 条件更新，如果有些为空，则不更新
     *
     * @param contents
     * @return
     */
    int updateByPrimaryKeyWithCondition(Contents contents);

    /**
     * 根据缩略名 找到文章
     *
     * @param slug
     * @return
     */
    List<Contents> selectBySlug(String slug);

    /**
     * 获取文章归档信息
     *
     * @return
     */
    List<Archive> findReturnArchive();

    /**
     * 归档文章查询
     * @return
     */
    List<Contents> getContentArchive(@Param("start")int start,@Param("end")int end);
}

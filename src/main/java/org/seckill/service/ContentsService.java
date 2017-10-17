package org.seckill.service;

import org.seckill.entity.Contents;

import java.util.List;

public interface ContentsService {
    /**
     * 查询所有文章记录
     *
     * @return
     */
    List<Contents> getContentsList(Integer limit,Integer offset);

    /**
     * 获取文章总数
     * @return
     */
    Integer getContentsCount();

    /**
     * 删除文章
     */
    void deleteContent(Integer cid);
}

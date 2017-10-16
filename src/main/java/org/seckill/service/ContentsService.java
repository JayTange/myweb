package org.seckill.service;

import org.seckill.entity.Contents;

import java.util.List;

public interface ContentsService {
    /**
     * 查询所有文章记录
     *
     * @return
     */
    List<Contents> getContentsList(Integer offset,Integer limit);
}

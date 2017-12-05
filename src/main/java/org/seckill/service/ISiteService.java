package org.seckill.service;

import org.seckill.entity.Archive;

import java.util.List;

public interface ISiteService {
    /**
     * 查询文章归档
     *
     * @return
     */
    List<Archive> getArchives();
}

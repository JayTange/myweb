package org.seckill.dao;

import org.seckill.entity.Metas;

import java.util.List;

public interface MetasDao {
    /**
     * 查询所有分类
     *
     * @param type
     * @return
     */
    List<Metas> queryAll(String type);
}

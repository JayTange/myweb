package org.seckill.dao;

import org.seckill.entity.Metas;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface MetasDao {
    /**
     * 查询所有分类
     *
     * @param type
     * @return
     */
    List<Metas> queryAll(String type);
}

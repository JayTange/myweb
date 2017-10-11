package org.seckill.dao;

import org.apache.ibatis.annotations.Param;
import org.seckill.entity.SecKill;

import java.util.Date;
import java.util.List;

public interface    SecKillDao {

    /**
     * 减库存
     *
     * @param seckillId
     * @param killTime
     * @return
     * 表示影响行数
     */
    int reduceNumber(@Param("seckillId")long seckillId, @Param("killTime")Date killTime);

    /**
     * 根据ID查询秒杀对象
     *
     * @param seckillId
     * @return
     */
    SecKill queryById(long seckillId);

    /**
     * 根据偏移量查询秒杀列表
     *
     * @param offset
     * @param limit
     * @return
     */
    List<SecKill> queryAll(@Param("offset") int offset,@Param("limit") int limit);
}

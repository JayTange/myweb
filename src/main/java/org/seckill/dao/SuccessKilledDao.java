package org.seckill.dao;

import org.apache.ibatis.annotations.Param;
import org.seckill.entity.SuccessKilled;

public interface SuccessKilledDao {
    /**
     * 插入购买明细,可过滤重复
     *
     * @param seckillId
     * @param userPhone
     * @return 如果影响行数>1,表示更新行数
     */
    int insertSuccessKill(@Param("seckillId") long seckillId, @Param("userPhone") long userPhone);

    /**
     * 根据id查询 successkilled并携带秒杀产品对象实体
     *
     * @param seckillId
     * @return
     */
    SuccessKilled queryByIdWithSecKill(@Param("seckillId") long seckillId,@Param("userPhone") long userPhone);
}

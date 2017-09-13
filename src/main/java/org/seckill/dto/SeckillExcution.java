package org.seckill.dto;

import org.seckill.entity.SuccessKilled;
import org.seckill.enums.SeckillStatEnum;

/**
 * 封装秒杀执行后的结构
 */
public class SeckillExcution {

    private long seckillId;

    // 秒杀执行结构
    private int state;

    // 状态表示
    private String stateInfo;

    private SuccessKilled successKilled;

    //秒杀成功返回所有信息

    public SeckillExcution(long seckillId, SeckillStatEnum statEnum, SuccessKilled successKilled) {

        this.seckillId = seckillId;

        this.state = statEnum.getState();

        this.stateInfo = statEnum.getStateInfo();

        this.successKilled = successKilled;

    }


    //秒杀失败

    public SeckillExcution(long seckillId, SeckillStatEnum statEnum) {

        this.seckillId = seckillId;

        this.state = statEnum.getState();

        this.stateInfo = statEnum.getStateInfo();

    }


    public long getSeckillId() {
        return seckillId;
    }

    public void setSeckillId(long seckillId) {
        this.seckillId = seckillId;
    }

    public int getState() {
        return state;
    }

    @Override
    public String toString() {
        return "SeckillExcution{" +
                "seckillId=" + seckillId +
                ", state=" + state +
                ", stateInfo='" + stateInfo + '\'' +
                ", successKilled=" + successKilled +
                '}';
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getStateInfo() {
        return stateInfo;
    }

    public void setStateInfo(String stateInfo) {
        this.stateInfo = stateInfo;
    }

    public SuccessKilled getSuccessKilled() {
        return successKilled;
    }

    public void setSuccessKilled(SuccessKilled successKilled) {
        this.successKilled = successKilled;
    }
}

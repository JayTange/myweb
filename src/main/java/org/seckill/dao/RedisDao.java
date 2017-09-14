package org.seckill.dao;

import com.dyuproject.protostuff.LinkedBuffer;
import com.dyuproject.protostuff.ProtostuffIOUtil;
import com.dyuproject.protostuff.runtime.RuntimeSchema;
import org.seckill.entity.SecKill;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;


public class RedisDao {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    private JedisPool jedisPool;

    public RedisDao(String ip,int port){
        jedisPool = new JedisPool(ip,port);
    }

    private RuntimeSchema<SecKill>schema = RuntimeSchema.createFrom(SecKill.class);

    public SecKill getSecKill(long seckillId){
        // redis操作逻辑
        try{
            Jedis jedis = jedisPool.getResource();
            try{
                String key = "seckill:"+seckillId;
                // 并没有实现内部序列化操作
                // get->byte[]->反序列化->Object(seckill)
                //采用自定义序列化
                // protostuff:pojo
                byte[] bytes = jedis.get(key.getBytes());
                //缓存获取到
                if(bytes!=null){
                    //空对象
                    SecKill secKill = schema.newMessage();
                    ProtostuffIOUtil.mergeFrom(bytes,secKill,schema);
                    // seckill 被反序列化
                    return secKill;
                }
            }finally {
                jedis.close();
            }
        }catch (Exception e){
            logger.error(e.getMessage(),e);
        }
        return null;
    }

    public String putSeckill(SecKill secKill){
        // set Object(Seckill)->序列化->byte[]
        try{
            Jedis jedis = jedisPool.getResource();
            try{
                String key = "seckill:"+secKill.getSeckillId();
                byte[] bytes = ProtostuffIOUtil.toByteArray(secKill,schema,
                        LinkedBuffer.allocate(LinkedBuffer.DEFAULT_BUFFER_SIZE));
                //设置缓存时间
                int timeout = 60*60;
                String result = jedis.setex(key.getBytes(),timeout,bytes);
                return result;
            }finally {
                jedis.close();
            }
        }catch (Exception e){
            logger.error(e.getMessage(),e);
        }
        return  null;
    }
}

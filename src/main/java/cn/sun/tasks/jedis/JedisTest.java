package cn.sun.tasks.jedis;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;

public class JedisTest {
    @Autowired
    private RedisTemplate redisTemplate;

}

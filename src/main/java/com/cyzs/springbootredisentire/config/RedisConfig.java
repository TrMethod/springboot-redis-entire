package com.cyzs.springbootredisentire.config;

import com.cyzs.springbootredisentire.bean.Employee;
import com.cyzs.springbootredisentire.bean.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import java.net.UnknownHostException;


/**
 * @Author xiaoh
 * @create 2019-09-05 9:42
 */
@Configuration
public class RedisConfig {

    /**
     *
     * @param redisConnectionFactory 连接工厂
     * @return redisTemple
     * @throws UnknownHostException 未知主机异常
     */
    @Bean
    public RedisTemplate<Object, Object> myRedisTemplate(
            RedisConnectionFactory redisConnectionFactory)
            throws UnknownHostException {
        RedisTemplate<Object, Object> template = new RedisTemplate<Object, Object>();
        template.setConnectionFactory(redisConnectionFactory);
        GenericJackson2JsonRedisSerializer serializer = new GenericJackson2JsonRedisSerializer();
        template.setDefaultSerializer(serializer);
        return template;
    }

    /*@Bean
    public RedisCacheManager empCacheManager(RedisTemplate<Object, Object> myRedisTemplate) {
        //RedisCacheManager cacheManager = new RedisCacheManager();
        //emp:3
        //cacheManager.setUsePrefix(true);
        return null;
    }*/

}

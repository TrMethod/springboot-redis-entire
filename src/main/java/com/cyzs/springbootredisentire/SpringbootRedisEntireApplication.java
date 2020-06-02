package com.cyzs.springbootredisentire;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

@EnableCaching
@EnableRedisHttpSession
@SpringBootApplication
public class SpringbootRedisEntireApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootRedisEntireApplication.class, args);
    }

}

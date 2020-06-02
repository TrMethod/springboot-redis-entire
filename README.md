架构：
  springboot+springbootjpa+redis
  

需求：
1.序列化可以阅读     y
2.用RedisTemplate操作redis    y
3.用注解的方式               
4.页面增删改查,分页，简单搜索
5.登录，权限控制       y



springsession实现共享session
   第一步  加依赖
            
             <!-- https://mvnrepository.com/artifact/org.springframework.session/spring-session-data-redis -->
             <dependency>
                 <groupId>org.springframework.session</groupId>
                 <artifactId>spring-session-data-redis</artifactId>
                 <version>2.1.7.RELEASE</version>
             </dependency>
   第二步  @EnableRedisHttpSession
   第三步  配置
          spring.session.store-type=redis
          spring.redis.host=127.0.0.1
          spring.redis.port=6379
   至此session已经达到共享的效果
   
   

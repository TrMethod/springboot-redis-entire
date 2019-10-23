package com.cyzs.springbootredisentire;

import com.cyzs.springbootredisentire.bean.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.BoundListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author xiaoh
 * @create 2019-09-05 9:48
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisTest {
    @Qualifier("myRedisTemplate")
    @Autowired
    RedisTemplate<Object, Object> myRedisTemplate;

    @Autowired
    RedisTemplate redisTemplate;

    /*@Autowired
    RedisTemplate<Object, List<User>> usersRedisTemplate;*/


   @Test
   public void test1(){
       User aa = new User("1", "aa");
       User bb = new User("2", "bb");
       User cc = new User("3", "cc");
       List<User> users = new ArrayList<>();
       users.add(aa);
       users.add(bb);
       users.add(cc);
       myRedisTemplate.boundValueOps("list02").set(users);

   }

   @Test
   public void test02(){
       List<User> list01 = (List<User>) myRedisTemplate.boundValueOps("list01").get();
       System.out.println(list01);
   }


    //自己定义的序列化机制
    @Test
    public void redisTest(){
        myRedisTemplate.boundValueOps("gg").set(new User("1","aa"));
    }
    @Test
    public void redisGet(){
        Object gg = myRedisTemplate.boundValueOps("gg").get();
        User aa= (User) gg;
        System.out.println(gg.getClass());

        System.out.println(gg);
    }



}

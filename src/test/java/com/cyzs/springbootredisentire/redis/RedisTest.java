package com.cyzs.springbootredisentire.redis;

import com.cyzs.springbootredisentire.bean.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @Author xiaoh
 * @create 2019-09-05 9:48
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisTest {

    @Autowired
    RedisTemplate<Object, Object> redisTemplate;

    @Autowired
    RedisTemplate<Object, Object> myRedisTemplate;


    /**
     * 获取hash值
     */
    @Test
    public void getHashType(){
        Object hashA = myRedisTemplate.opsForHash().get("hashA", "1");
        System.out.println(hashA);
    }

    /**
     * 操作hash类型
     */
    @Test
    public void addHashType(){
        User user = getUser();
        myRedisTemplate.opsForHash().put("hashA", "1", user);
        myRedisTemplate.opsForHash().put("hashA", "2", user);
    }

    /**
     * 获取list类型的数据
     */
    @Test
    public void getListsType(){
        List<Object> listA = myRedisTemplate.opsForList().range("ListA", 0, -1);
        System.out.println(listA);
    }

    /**
     * 操作list类型
     */
    @Test
    public void addListsType(){
        /*myRedisTemplate.opsForList().leftPush("ListA", "AA");
        myRedisTemplate.opsForList().leftPush("ListA", "BB");
        myRedisTemplate.opsForList().leftPush("ListA", "CC");*/
        //存放对象
        User user = new User();
        user.setId("1");user.setName("王二");user.setPassword("123456");user.setLevel("1");
        myRedisTemplate.opsForList().leftPush("ListObject", user);
        myRedisTemplate.opsForList().leftPush("ListObject", user);
        myRedisTemplate.opsForList().leftPush("ListObject", user);
    }

    /**
     * 测试反序列化key是string，value是Object
     */
    @Test
    public void getStringObject(){
        Object a = myRedisTemplate.opsForValue().get("A");
        System.out.println(a);
    }
    /**
     * 测试string类型存放对象
     */
    @Test
    public void addStringObject(){
        User user = new User();
        user.setId("1");user.setName("王二");user.setPassword("123456");user.setLevel("1");
        myRedisTemplate.opsForValue().set("A", user);
    }
    /**
     * 测试存放string类型
     */
    @Test
    public void addString(){
        myRedisTemplate.opsForValue().set("师傅","唐生");
    }

    /**
     * 由于myRedisTemplate使用GenericJackson2JsonRedisSerializer序列化
     * 可以看到存的数据
     */
    @Test
    public void myRedisTemplateTest(){
        myRedisTemplate.opsForValue().set("true", true);
    }

    /**
     * 经过测试redisTemplate序列化使用jdk的序列方式，
     * 由于二进制的形式不可以直接看到存的值
     */
    @Test
   public void redis(){
       redisTemplate.opsForValue().set("aa", "AA");
   }

   public User getUser(){
       User user = new User();
       user.setId("1");user.setName("王二");user.setPassword("123456");user.setLevel("1");
       return user;
   }

}

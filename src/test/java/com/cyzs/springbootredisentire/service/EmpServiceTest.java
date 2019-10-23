package com.cyzs.springbootredisentire.service;

import com.cyzs.springbootredisentire.bean.Employee;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * @Author xiaoh
 * @create 2019-09-10 17:06
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class EmpServiceTest {
    @Autowired
    RedisTemplate myRedisTemplate;

    //测试能不能去除数据
    @Test
    public void test(){
        Employee emp1 = (Employee) myRedisTemplate.boundValueOps("emp1").get();
        System.out.println(emp1);
    }

}
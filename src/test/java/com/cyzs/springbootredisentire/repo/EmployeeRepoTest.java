package com.cyzs.springbootredisentire.repo;

import com.cyzs.springbootredisentire.bean.Employee;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.*;

import static org.junit.Assert.*;

/**
 * @Author xiaoh
 * @create 2019-09-10 17:53
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class EmployeeRepoTest {
    @Autowired
    EmployeeRepo employeeRepo;

    //分页查询
    @Test
    public void findPage(){
        Page<Employee> all = employeeRepo.findAll(PageRequest.of(1, 10));
        System.out.println(all.getTotalPages());
        List<Employee> emps = all.getContent();
        System.out.println(emps);
    }

    //修改
    @Test
    public void saveAndFlush(){
        Employee employee = employeeRepo.findById(1).get();
        System.out.println(employee);
        employee.setName("王四");
        employeeRepo.saveAndFlush(employee);
        System.out.println(employee);
    }


    //修改
    @Test
    public void update(){
        Employee employee = new Employee();
        employee.setName("王四");
        Optional<Employee> byId = employeeRepo.findById(2);
        Employee employee1 = byId.get();
        employee1.setName(employee.getName());
        employeeRepo.saveAndFlush(employee1);

    }

    //增加
    @Test
    public void add(){

        for (int i=0;i<100;i++){
            Employee employee = new Employee();
            employee.setName("王三");
            employee.setBirth(new Date());
            employee.setDepartment("开发部");
            employee.setEmail("11@qq,com");
            employeeRepo.saveAndFlush(employee);
        }

        //employeeRepo.save(employee);
    }

    //删除表数据
    @Test
    public void dropTeble(){
        employeeRepo.truncateTable();
    }

}
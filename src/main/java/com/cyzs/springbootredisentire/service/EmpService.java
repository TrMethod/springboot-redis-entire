package com.cyzs.springbootredisentire.service;

import com.cyzs.springbootredisentire.bean.Employee;
import com.cyzs.springbootredisentire.repo.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * @Author xiaoh
 * @create 2019-09-10 16:44
 */
@Service
public class EmpService {
    @Autowired
    EmployeeRepo employeeRepo;

    @Autowired
    @Qualifier("myRedisTemplate")
    RedisTemplate<Object, Object> myRedisTemplate;

    public Employee findById(Integer id){
        Employee o = (Employee) myRedisTemplate.boundValueOps("emp" + id).get();
        if (o==null){
            Optional<Employee> byId = employeeRepo.findById(id);
            o = byId.get();
            myRedisTemplate.boundValueOps("emp" + id).set(o);
        }
        return o;
    }

    public void updateById(Employee e){
        Employee employee = employeeRepo.findById(e.getId()).get();

        employeeRepo.saveAndFlush(e);
        myRedisTemplate.delete("emp"+e.getId());
    }

    //public


}

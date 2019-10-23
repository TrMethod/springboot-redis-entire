package com.cyzs.springbootredisentire.controller;

import com.cyzs.springbootredisentire.bean.Employee;
import com.cyzs.springbootredisentire.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Author xiaoh
 * @create 2019-09-10 16:43
 */
@RestController
public class EmployeeController {
    @Autowired
    EmpService empService;

    @RequestMapping("/emp/{id}")
    public Employee findEmpById(@PathVariable("id") Integer id){
       return empService.findById(id);
    }

    @ResponseBody
    @PostMapping("/update")
    public String update(Employee e){
        empService.updateById(e);
        return "ok";
    }

    @RequestMapping("/emp/all")
    public String empAll(){

        return "/emp/list";
    }

}

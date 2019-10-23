package com.cyzs.springbootredisentire.service;

import com.cyzs.springbootredisentire.repo.DepartmentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Author xiaoh
 * @create 2019-09-10 16:46
 */
@Service
public class DeptService {
    @Autowired
    DepartmentRepo departmentRepo;

}

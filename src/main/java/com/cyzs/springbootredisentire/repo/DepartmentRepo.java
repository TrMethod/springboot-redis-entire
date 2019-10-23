package com.cyzs.springbootredisentire.repo;

import com.cyzs.springbootredisentire.bean.Department;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Author xiaoh
 * @create 2019-09-10 16:15
 */
public interface DepartmentRepo extends JpaRepository<Department,Integer> {
}

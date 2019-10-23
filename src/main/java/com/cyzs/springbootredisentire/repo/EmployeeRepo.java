package com.cyzs.springbootredisentire.repo;

import com.cyzs.springbootredisentire.bean.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;

/**
 * @Author xiaoh
 * @create 2019-09-10 16:14
 */
public interface EmployeeRepo extends JpaRepository<Employee,Integer> {
    @Transactional(rollbackOn={Exception.class})
    @Modifying
    @Query(value = "truncate table tb_emp", nativeQuery = true)
    void truncateTable();
}

package com.cyzs.springbootredisentire.bean;

import lombok.Data;

import javax.persistence.*;

/**
 * @Author xiaoh
 * @create 2019-09-10 16:00
 */
@Entity
@Table(name = "tb_department")
@Data
public class Department {
    @Id
    //IDENTITY主键自增
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name="department_name",length = 32)
    private String departmentName;
}

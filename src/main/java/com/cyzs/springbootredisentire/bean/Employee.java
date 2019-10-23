package com.cyzs.springbootredisentire.bean;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

/**
 * @Author xiaoh
 * @create 2019-09-10 15:56
 */
@Entity
@Data
@Table(name = "tb_emp")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "name",length = 32)
    private String name;
    @Column(length = 32)
    private String department;
    @Column(length = 50)
    private String email;
    //1 male, 0 female
    @Column(length = 2)
    private Integer gender;
    @Column
    @DateTimeFormat(pattern = "yyyy-MM-dd hh:MM:ss SSS")
    private Date birth;

}

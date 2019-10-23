package com.cyzs.springbootredisentire.bean;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @Author xiaoh
 * @create 2019-09-05 9:43
 */
@Entity
@Table(name = "tb_user")
//strategy = "uuid"  uuid是生成器的名字，有12种生成器
@GenericGenerator(name = "uuid",strategy = "uuid")
@Data
public class User implements Serializable {
    @Id
    @GeneratedValue(generator = "uuid")
    private String id;
    @Column(length = 32)
    private String name;
    @Column(length = 32)
    private String password;
    @Column(length = 32)
    private String level;
    public User(String id,String name){
        this.id=id;
        this.name=name;
    }
    public User(){
        super();
    }
}

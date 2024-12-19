package com.xworkz.admin.entity;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "login_table")
@RequiredArgsConstructor
@Data
@NamedQuery(name = "getPasswordName",query = "select a.password from AdminEntity a where a.name=:setName")
//@NamedQuery(name = "getAll",query = "select a from LoginEntity a where a.name=:setName")
public class AdminEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private int age;
    private String email;
    private String password;
   // private String conPassword;
    private  String phNo;
}

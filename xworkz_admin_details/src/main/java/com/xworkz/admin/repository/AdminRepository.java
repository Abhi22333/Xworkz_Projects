package com.xworkz.admin.repository;


import com.xworkz.admin.dto.SigninDTO;
import com.xworkz.admin.entity.AdminEntity;

public interface AdminRepository {

    boolean save(AdminEntity adminEntity);
    String getPassword(SigninDTO signinDTO) ;
}

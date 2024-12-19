package com.xworkz.admin.service;

import com.xworkz.admin.dto.AdminDTO;
import com.xworkz.admin.dto.SigninDTO;

public interface AdminService {

    boolean valid(AdminDTO adminDTO);
    boolean validPassword(SigninDTO signinDTO);
}


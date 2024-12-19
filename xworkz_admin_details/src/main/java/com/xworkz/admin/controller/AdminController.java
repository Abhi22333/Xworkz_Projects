package com.xworkz.admin.controller;

import com.xworkz.admin.dto.AdminDTO;
import com.xworkz.admin.dto.SigninDTO;
import com.xworkz.admin.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class AdminController {
    @Autowired
    private AdminService adminService;
    @PostMapping("login")
    public String onSubmit(AdminDTO adminDTO){
        System.out.println(adminDTO);
        boolean isvalid=adminService.valid(adminDTO);
        if(isvalid) {
            return "success.jsp";
        }
        return "signup.jsp";
    }
@PostMapping("/signin")
    public String signin(SigninDTO signinDTO){
      boolean valid=  adminService.validPassword(signinDTO);
      if(valid) {
          return "index.jsp";
      }
      else{
          return "signin.jsp";
      }
}

}

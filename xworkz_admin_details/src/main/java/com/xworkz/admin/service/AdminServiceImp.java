package com.xworkz.admin.service;

import com.xworkz.admin.dto.AdminDTO;
import com.xworkz.admin.dto.SigninDTO;
import com.xworkz.admin.entity.AdminEntity;
import com.xworkz.admin.repository.AdminRepository;
import com.xworkz.admin.repository.AdminRepositoryImp;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImp  implements AdminService {


    @Override
    public boolean valid(AdminDTO adminDTO) {
        boolean isvalid = true;

        String name = adminDTO.getName();
        if (name.length() > 5 && !name.matches("^[a-zA-Z0-9]+$")) {
            System.out.println("name valid");
            //  isvalid = true;
        } else {
            isvalid = false;
            System.out.println("name is invalid");
        }
        int age = adminDTO.getAge();
        if (age > 18) {
            // isvalid = true;
            System.out.println("age is valid");
        } else {
            isvalid = false;
            System.out.println("age is invalid");
            // return isvalid;
        }
        String email = adminDTO.getEmail();
        if (email.contains("@")) {
            // isvalid = true;
            System.out.println("email is valid");
        } else {
            isvalid = false;
            System.out.println("email is invalid");
            //return isvalid;
        }

        String password = adminDTO.getPassword();


        String conpassword = adminDTO.getConPassword();
        if (conpassword.equals(password)) {
            //isvalid = true;
            System.out.println("comfpassword is valid");
        } else {
            isvalid = false;
            System.out.println("confpassword is in valid");
            //return isvalid;
        }

        String phNo = adminDTO.getPhNo();
        if (phNo.startsWith("9") && phNo.length() == 10) {
            // isvalid = true;
            System.out.println("phno is valid");
        } else {
            isvalid = false;
            System.out.println("phone is in valid");
            // return isvalid;
        }

        if (isvalid) {
            BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
            String enpassword = bCryptPasswordEncoder.encode(password);
            AdminEntity entity = new AdminEntity();
            entity.setName(adminDTO.getName());
            entity.setAge(adminDTO.getAge());
            entity.setEmail(adminDTO.getEmail());
            entity.setPassword(enpassword);
            //entity.setConPassword(adminDTO.getConPassword());
            entity.setPhNo(adminDTO.getPhNo());
            AdminRepository adminRepository = new AdminRepositoryImp();
            boolean saved = adminRepository.save(entity);
        }
        System.out.println(isvalid);
        return isvalid;
    }

    public boolean validPassword(SigninDTO signinDTO) {
        boolean istrue = false;
        AdminRepository loginRepository1 = new AdminRepositoryImp();
        String pass = loginRepository1.getPassword(signinDTO);
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        boolean match = bCryptPasswordEncoder.matches(signinDTO.getPassword(), pass);
        System.out.println(pass);
        if (pass != null) {

            if (match) {
                System.out.println("password matching");
                istrue = true;
                return istrue;

            } else {
                System.out.println("password not  matching");
                return istrue;
            }

        }
        return istrue;
    }
}

package com.xworkz.admin.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@ComponentScan("com.xworkz.admin")
@EnableWebMvc

public class AdminConfiguration {

    AdminConfiguration(){
        System.out.println("running AdminConfiguration");
    }
}
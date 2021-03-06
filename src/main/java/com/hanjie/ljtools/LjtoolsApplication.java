package com.hanjie.ljtools;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class LjtoolsApplication extends SpringBootServletInitializer {
    //hello
    public static void main(String[] args) {
        SpringApplication.run(LjtoolsApplication.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder){
        return builder.sources(LjtoolsApplication.class);
    }

}

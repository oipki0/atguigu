package com.atguigu.srb;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"com.atguigu"})
public class SrbApplication {
    public static void main(String[] args) {
        SpringApplication.run(SrbApplication.class,args);
    }
}

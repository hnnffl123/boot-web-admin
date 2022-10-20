package com.sgg.admin;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.redis.RedisAutoConfiguration;
import org.springframework.boot.web.servlet.ServletComponentScan;

@MapperScan("com.sgg.admin.mapper")
@ServletComponentScan(basePackages = "com.sgg.admin")
@SpringBootApplication(exclude = RedisAutoConfiguration.class)
public class BootWebAdminApplication {
    
    public static void main(String[] args) {
        SpringApplication.run(BootWebAdminApplication.class, args);
    }
    
}

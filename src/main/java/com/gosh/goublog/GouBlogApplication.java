package com.gosh.goublog;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.gosh.goublog.mapper")
@SpringBootApplication
public class GouBlogApplication {

    public static void main(String[] args) {
        SpringApplication.run(GouBlogApplication.class, args);
    }

}

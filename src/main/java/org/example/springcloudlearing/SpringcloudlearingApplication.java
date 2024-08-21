package org.example.springcloudlearing;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("org.example.springcloudlearing.mapper")
public class SpringcloudlearingApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringcloudlearingApplication.class, args);
    }

}

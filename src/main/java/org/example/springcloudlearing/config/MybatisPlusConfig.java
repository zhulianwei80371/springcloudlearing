package org.example.springcloudlearing.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MybatisPlusConfig {

    @Bean
    public CustomIdGenerator customIdGenerator() {

        return new CustomIdGenerator();

    }
}
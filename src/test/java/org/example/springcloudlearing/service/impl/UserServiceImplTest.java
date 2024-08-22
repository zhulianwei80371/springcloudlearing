package org.example.springcloudlearing.service.impl;

import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.example.springcloudlearing.SpringcloudlearingApplication;
import org.example.springcloudlearing.entity.vip.User;
import org.example.springcloudlearing.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest(classes = SpringcloudlearingApplication.class)
@Slf4j
class UserServiceImplTest {

    @Resource
    private UserService userService;

    @Test
    void updateBalance() {
        User one =  new User();
        one.setName("service save");

        userService.save(one);

    }
}
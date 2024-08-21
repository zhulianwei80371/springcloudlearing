package org.example.springcloudlearingservice.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.example.springcloudlearing.entity.User;
import org.example.springcloudlearing.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.example.springcloudlearing.SpringcloudlearingApplication;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = SpringcloudlearingApplication.class)
@Slf4j
class UserMapperTest {

    @Autowired
    private UserMapper userMapper;
    @Test
    void insertUser() {
//        log.info("user id 1:{}",userMapper.selectById("1"));

        User one =new User();
        one.setBalance(1000);
        one.setName("aaazhulianwei00900");

        userMapper.insert(one);

//        UUID uuid = UUID.randomUUID();
//        String uniqueId = uuid.toString();
//        log.info("uniqueId id 1:{}",uniqueId);
//        log.info("uniqueId id 1:{}",uniqueId.length());
//        log.info("uniqueId id uuid.variant():{}",uuid.variant());
//
//        Snowflake snowflake = IdUtil.getSnowflake(1, 1);
//        long id = snowflake.nextId();
//
//        log.info("uniqueId id 1:{}",id);
//        log.info("uniqueId id 1:{}",String.valueOf(id).length());
    }

    @Test
    void updateUser() {
        User one =new User();
        one.setBalance(981);
        one.setName("updateByQueryWrapper");
        QueryWrapper<User> queryWrapper = new QueryWrapper<User>().eq("name","aaazhulianwei00909");
        userMapper.update(one,queryWrapper);

    }
}
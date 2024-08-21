package org.example.springcloudlearing.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import org.example.springcloudlearing.entity.User;
import org.example.springcloudlearing.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.example.springcloudlearing.SpringcloudlearingApplication;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

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

    @Test
    public void queryWrapper(){
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.select("id","name");
        queryWrapper.like("name","zhulianwei");
        queryWrapper.ge("balance","99");

        List allUser = userMapper.selectList(queryWrapper);
        allUser.stream().forEach( user -> log.info("user:{}",user) );
    }
    @Test
    public void queryLamdaWrapper(){
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<User>();
        queryWrapper.select(User::getId,User::getName);
        queryWrapper.like(User::getName,"zhulianwei");
        queryWrapper.ge(User::getBalance,"99");

        List allUser = userMapper.selectList(queryWrapper);
        allUser.stream().forEach( user -> log.info("user:{}",user) );
    }

    @Test
    public void updateByQueryWrapper(){
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("name","aaazhulianwei00900");
        User user = new User();
        user.setBalance(2000);
        userMapper.update(user,queryWrapper);
    }
    @Test
    public void updateByUpdateWrapper(){

        List<String> ids = List.of("1f23dccf2a454626b67713dc8a9b4a52","44f5e82ae53f9e5416b17453cf3221ae");
        UpdateWrapper updateWrapper = new UpdateWrapper();
        updateWrapper.in("id",ids);
        updateWrapper.setSql("balance = balance - 100");
        userMapper.update(null,updateWrapper);
    }


    @Test
    public void customeUpdateByUpdateWrapper(){

        List<String> ids = List.of("1f23dccf2a454626b67713dc8a9b4a52","44f5e82ae53f9e5416b17453cf3221ae");

        int amount = 89;

        QueryWrapper<User> wrapper = new QueryWrapper<User>();
        wrapper.in("id",ids);


        userMapper.updateBalanceByIds(amount,wrapper);
    }


}
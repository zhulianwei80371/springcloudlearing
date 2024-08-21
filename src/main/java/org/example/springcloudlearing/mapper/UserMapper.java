package org.example.springcloudlearing.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import org.apache.ibatis.annotations.Param;
import org.example.springcloudlearing.entity.User;
import org.springframework.stereotype.Repository;

/**
* @author lianweizhu
* @description 针对表【t_user】的数据库操作Mapper
* @createDate 2024-08-19 15:17:58
* @Entity com.example.springcloudlearing.entity.User
*/
@Repository
public interface UserMapper extends BaseMapper<User> {

    void updateBalanceByIds(@Param("amount") int amount, @Param(Constants.WRAPPER) QueryWrapper<User> wrapper);
}





package org.example.springcloudlearing.mapper;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;
import org.example.springcloudlearing.entity.vip.User;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;

/**
* @author lianweizhu
* @description 针对表【t_user】的数据库操作Mapper
* @createDate 2024-08-19 15:17:58
* @Entity com.example.springcloudlearing.entity.User
*/
@Repository
public interface UserMapper extends BaseMapper<User> {

    void updateBalanceByIds(@Param("amount") BigDecimal amount, @Param(Constants.WRAPPER) QueryWrapper<User> wrapper);

    @Update("update t_user set balance = balance - #{amount}, where id = #{id}")
    void deductBalance(@Param("id") String id, @Param("amount") BigDecimal amount);
}





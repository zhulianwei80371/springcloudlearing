package org.example.springcloudlearing.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.example.springcloudlearing.entity.vip.User;
import org.example.springcloudlearing.mapper.UserMapper;
import org.example.springcloudlearing.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

/**
* @author lianweizhu
* @description 针对表【t_user】的数据库操作Service实现
* @createDate 2024-08-19 15:17:58
*/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService{

    @Autowired
    private UserMapper userMapper;

  @Override
  public void updateBalance(String userId, BigDecimal amount){

      User currentUser = this.getById(userId);
      if(currentUser == null ||  currentUser.getBalance().compareTo(amount)<0){
          throw new RuntimeException("用户不存在或余额不足");
      }
      //      // 更新余额 = 余额 - xx
      currentUser.setBalance(currentUser.getBalance().subtract(amount));
      LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();
      wrapper.eq(User::getId,userId);
//      userMapper.updateBalanceByIds(amount,wrapper);

  }

    @Override
    public void deductBalance(String userId, BigDecimal balance){

        User currentUser = this.getById(userId);
        if(currentUser == null ||  currentUser.getBalance().compareTo(balance)<0){
            throw new RuntimeException("用户不存在或余额不足");
        }
        userMapper.deductBalance(currentUser.getId(),balance);
    }

    @Override
    public void deductBalanceLamda(String userId, BigDecimal balance){

        User currentUser = this.getById(userId);
        if(currentUser == null ||  currentUser.getBalance().compareTo(balance)<0){
            throw new RuntimeException("用户不存在或余额不足");
        }
        lambdaUpdate().set(User::getBalance,currentUser.getBalance().subtract(balance))
                .set(currentUser.getBalance().subtract(balance).compareTo(BigDecimal.ZERO)<0,User::getBalance,new BigDecimal("9999.99"))
                .eq(User::getId,userId)
                .update();
    }

    @Override
    public List<User> queryUsers(String name, BigDecimal balance, String email) {
        return  lambdaQuery().like(User::getName,name).gt(User::getBalance,balance).like(User::getEmail,email).list();
    }
}





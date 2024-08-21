package org.example.springcloudlearing.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.baomidou.mybatisplus.extension.toolkit.Db;
import org.example.springcloudlearing.entity.User;
import org.example.springcloudlearing.mapper.UserMapper;
import org.example.springcloudlearing.service.UserService;
import org.springframework.stereotype.Service;

/**
* @author lianweizhu
* @description 针对表【t_user】的数据库操作Service实现
* @createDate 2024-08-19 15:17:58
*/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService{

  @Override
  public void updateBalance(){
      User user = Db.lambdaQuery(User.class).eq(User::getName,"zhulianwei").one();
      Integer id = Integer.valueOf(user.getId());
      // 更新余额 = 余额 - xx
      user.setBalance(user.getBalance() - 100);
      Db.lambdaUpdate(User.class).update(user);

  }
}





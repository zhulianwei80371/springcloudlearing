package org.example.springcloudlearing.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.example.springcloudlearing.entity.User;

/**
* @author lianweizhu
* @description 针对表【t_user】的数据库操作Service
* @createDate 2024-08-19 15:17:58
*/
public interface UserService extends IService<User> {

    void updateBalance();
}

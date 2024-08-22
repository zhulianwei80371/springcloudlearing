package org.example.springcloudlearing.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.example.springcloudlearing.entity.vip.User;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author lianweizhu
 * @description 针对表【t_user】的数据库操作Service
 * @createDate 2024-08-19 15:17:58
 */
public interface UserService extends IService<User> {

    public void updateBalance(String userId, BigDecimal balance);
    public void deductBalance(String userId, BigDecimal balance);

    void deductBalanceLamda(String userId, BigDecimal balance);

    List<User> queryUsers(String name, BigDecimal balance, String email);
}
package com.waylau.spring.boot.bootstrap.service;

import com.waylau.spring.boot.bootstrap.domain.User;

/**
 * Created by tangxiewen on 2017/8/23.
 */
public interface IUserService {
    /**
     * 保存用户
     * @param user
     * @return
     */
    User saveUser(User user);
}

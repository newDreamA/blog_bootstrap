package com.waylau.spring.boot.bootstrap.service;

import com.waylau.spring.boot.bootstrap.domain.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

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

    /**
     * 根据用户名进行分页模糊查询
     * @param user
     * @return
     */
    Page<User> listUsersByNameLike(String name, Pageable pageable);


    /**
     * 根据id获取用户
     * @param user
     * @return
     */
    User getUserById(Long id);

}

package com.waylau.spring.boot.bootstrap.service.impl;

import com.waylau.spring.boot.bootstrap.domain.User;
import com.waylau.spring.boot.bootstrap.repository.UserRepository;
import com.waylau.spring.boot.bootstrap.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * Created by tangxiewen on 2017/8/23.
 */
@Service
public class UserServiceImpl implements IUserService,UserDetailsService {

    @Autowired
    private UserRepository userRepository;


    @Transactional
    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username);
    }
}

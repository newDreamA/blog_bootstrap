package com.waylau.spring.boot.bootstrap.service.impl;

import com.waylau.spring.boot.bootstrap.domain.Authority;
import com.waylau.spring.boot.bootstrap.repository.AuthorityRepository;
import com.waylau.spring.boot.bootstrap.service.IAuthorityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by tangxiewen on 2017/8/24.
 */
@Service
public class AuthorityServiceImpl implements IAuthorityService {
    @Autowired
    private AuthorityRepository authorityRepository;

    @Override
    public Authority getAuthorityById(Long id) {
        return authorityRepository.findOne(id);
    }
}

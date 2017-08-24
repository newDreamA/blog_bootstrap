package com.waylau.spring.boot.bootstrap.service;

import com.waylau.spring.boot.bootstrap.domain.Authority;

/**
 * Created by tangxiewen on 2017/8/24.
 */
public interface IAuthorityService {
    /**
     * 根据id获取 Authority
     * @param Authority
     * @return
     */
    Authority getAuthorityById(Long id);

}

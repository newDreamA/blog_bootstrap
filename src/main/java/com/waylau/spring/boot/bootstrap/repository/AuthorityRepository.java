package com.waylau.spring.boot.bootstrap.repository;

import com.waylau.spring.boot.bootstrap.domain.Authority;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by tangxiewen on 2017/8/24.
 */
public interface AuthorityRepository extends JpaRepository<Authority, Long> {
}

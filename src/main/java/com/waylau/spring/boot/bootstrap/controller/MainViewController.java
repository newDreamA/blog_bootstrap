package com.waylau.spring.boot.bootstrap.controller;

import com.waylau.spring.boot.bootstrap.domain.Authority;
import com.waylau.spring.boot.bootstrap.domain.User;
import com.waylau.spring.boot.bootstrap.service.IAuthorityService;
import com.waylau.spring.boot.bootstrap.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tangxiewen on 2017/8/23.
 */
@Controller
public class MainViewController {
    private static final Long ROLE_USER_AUTHORITY_ID = 2L;

    @Autowired
    IUserService userService;
    @Autowired
    private IAuthorityService authorityService;


    @GetMapping("/")
    public String root() {
        return "redirect:/index";
    }

    @GetMapping("/index")
    public String index() {
        return "index";
    }

    @GetMapping("/register")
    public String register(){
        return "register";
    }

    @PostMapping("/register")
    public String registerUser(User user) {
        List<Authority> authorities = new ArrayList<>();
        authorities.add(authorityService.getAuthorityById(ROLE_USER_AUTHORITY_ID));
        user.setAuthorities(authorities);
        User newUser =userService.saveUser(user);


        return "redirect:/login";
    }
}

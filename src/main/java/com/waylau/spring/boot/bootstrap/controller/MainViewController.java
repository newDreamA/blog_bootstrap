package com.waylau.spring.boot.bootstrap.controller;

import com.waylau.spring.boot.bootstrap.domain.User;
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
    @Autowired
    IUserService userService;

    @GetMapping("/register")
    public String register(){
        return "register";
    }

    @PostMapping("/register")
    public String registerUser(User user) {
        userService.saveUser(user);
        return "redirect:/login";
    }
}

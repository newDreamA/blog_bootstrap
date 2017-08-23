package com.waylau.spring.boot.bootstrap.controller;

import com.waylau.spring.boot.bootstrap.domain.Menu;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by tangxiewen on 2017/8/23.
 */
@Controller
@RequestMapping("/admins")
public class AdminController {
    @GetMapping("/list")
    public ModelAndView getListUser(Model model){
        List<Menu> list = new ArrayList<Menu>();
        list.add(new Menu("用户管理", "/users"));
        list.add(new Menu("角色管理", "/roles"));
        list.add(new Menu("博客管理", "/blogs"));
        list.add(new Menu("评论管理", "/commits"));
        model.addAttribute("list", list);
        return new ModelAndView("/admins/index", "model", model);
    }
}

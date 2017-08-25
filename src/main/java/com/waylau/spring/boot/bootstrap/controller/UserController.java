package com.waylau.spring.boot.bootstrap.controller;

import java.util.ArrayList;
import java.util.List;

import com.waylau.spring.boot.bootstrap.service.IAuthorityService;
import com.waylau.spring.boot.bootstrap.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import com.waylau.spring.boot.bootstrap.domain.User;
import com.waylau.spring.boot.bootstrap.repository.UserRepository;

import javax.validation.ConstraintViolationException;

/**
 * 用户控制器.
 * 
 * @author <a href="https://waylau.com">Way Lau</a>
 * @date 2017年2月26日
 */
@RestController
@RequestMapping("/users")
@PreAuthorize("hasAuthority('ROLE_ADMIN')")// 指定角色权限才能操作方法
public class UserController {

	@Autowired
	private IUserService userService;

	@Autowired
	private IAuthorityService authorityService;

	/**
	 * 查询所用用户
	 * @return
	 */
	@GetMapping
	public ModelAndView list(@RequestParam(value="async",required=false) boolean async,
							 @RequestParam(value="pageIndex",required=false,defaultValue="0") int pageIndex,
							 @RequestParam(value="pageSize",required=false,defaultValue="10") int pageSize,
							 @RequestParam(value="name",required=false,defaultValue="") String name,
							 Model model) {

		Pageable pageable = new PageRequest(pageIndex, pageSize);
		Page<User> page = userService.listUsersByNameLike(name, pageable);
		List<User> list = page.getContent();	// 当前所在页面数据列表

		model.addAttribute("page", page);
		model.addAttribute("userList", list);
		return new ModelAndView(async==true?"users/list :: #mainContainerRepleace":"users/list", "userModel", model);
	}

	/**
	 * 获取 form 表单页面
	 * @param user
	 * @return
	 */
	@GetMapping("/add")
	public ModelAndView createForm(Model model) {
		model.addAttribute("user", new User(null, null, null, null));
		return new ModelAndView("users/add", "userModel", model);
	}


	/**
	 * 获取修改用户的界面，及数据
	 * @param user
	 * @return
	 */
	@GetMapping(value = "edit/{id}")
	public ModelAndView modifyForm(@PathVariable("id") Long id, Model model) {
		User user = userService.getUserById(id);
		model.addAttribute("user", user);
		return new ModelAndView("users/edit", "userModel", model);
	}

}

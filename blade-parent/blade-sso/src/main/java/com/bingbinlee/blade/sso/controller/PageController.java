package com.bingbinlee.blade.sso.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Description 页面跳转Controller
 * @author	libingbin2015@aliyun.com
 * @date	2016年9月15日上午11:51:53
 * @version 1.0
 */
@Controller
@RequestMapping("/page")
public class PageController {

	@RequestMapping(value = "register")
	public String showRegister() {
		return "register";
	}

	@RequestMapping(value = "login")
	public String showLogin(String redirect, Model model) {
		model.addAttribute("redirect", redirect);
		return "login";
	}
}

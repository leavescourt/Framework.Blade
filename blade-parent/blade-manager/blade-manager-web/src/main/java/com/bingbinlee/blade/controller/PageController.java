package com.bingbinlee.blade.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Description 页面跳转Controller
 * @author	libingbin2015@aliyun.com
 * @date	2016年9月15日上午11:51:53
 * @version 1.0
 */
@Controller
public class PageController {

	/**
	 * 打开首页
	 * @return
	 */
	@RequestMapping("/")
	public String showIndex() {
		return "index";
	}

	/**
	 * 展示其他页面
	 * @param page
	 * @return
	 */
	@RequestMapping("/{page}")
	public String showpage(@PathVariable String page) {
		return page;
	}
}

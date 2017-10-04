package com.bingbinlee.blade.controller;


import com.bingbinlee.blade.common.pojo.BladeResult;
import com.bingbinlee.blade.pojo.TbContent;
import com.bingbinlee.blade.service.impl.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 内容管理Controller
 * @author	libingbin2015@aliyun.com
 * @date	2016年10月1日下午9:11:51
 * @version 1.0
 */
@Controller
@RequestMapping("/content")
public class ContentController {

	@Autowired
	private ContentService contentService;
	
	@RequestMapping("/save")
	@ResponseBody
	public BladeResult insertContent(TbContent content) {
		BladeResult result = contentService.insertContent(content);
		return result;
	}
}

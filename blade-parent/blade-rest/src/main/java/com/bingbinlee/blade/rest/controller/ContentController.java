package com.bingbinlee.blade.rest.controller;


import com.bingbinlee.blade.common.pojo.BladeResult;
import com.bingbinlee.blade.common.utils.ExceptionUtil;
import com.bingbinlee.blade.pojo.TbContent;
import com.bingbinlee.blade.rest.service.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * 内容管理Controller
 * @author	libingbin2015@aliyun.com
 * @date	2016年9月15日下午11:43:51
 * @version 1.0
 */
@Controller
@RequestMapping("/content")
public class ContentController {

	@Autowired
	private ContentService contentService;
	
	@RequestMapping("/list/{contentCategoryId}")
	@ResponseBody
	public BladeResult getContentList(@PathVariable Long contentCategoryId) {
		try {
			List<TbContent> list = contentService.getContentList(contentCategoryId);
			return BladeResult.ok(list);
		} catch (Exception e) {
			e.printStackTrace();
			return BladeResult.build(500, ExceptionUtil.getStackTrace(e));
		}
	}
}
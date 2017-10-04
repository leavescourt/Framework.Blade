package com.bingbinlee.blade.rest.controller;

import com.bingbinlee.blade.common.pojo.BladeResult;
import com.bingbinlee.blade.rest.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 缓存同步Controller
 * @author	libingbin2015@aliyun.com
 * @date	2016年9月15日下午11:43:51
 * @version 1.0
 */
@Controller
@RequestMapping("/cache/sync")
public class RedisController {

	@Autowired
	private RedisService redisService;
	
	@RequestMapping("/content/{contentCid}")
	@ResponseBody
	public BladeResult contentCacheSync(@PathVariable Long contentCid) {
		BladeResult result = redisService.syncContent(contentCid);
		return result;
	}
}

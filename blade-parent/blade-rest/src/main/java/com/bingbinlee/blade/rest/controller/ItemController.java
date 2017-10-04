package com.bingbinlee.blade.rest.controller;


import com.bingbinlee.blade.common.pojo.BladeResult;
import com.bingbinlee.blade.rest.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 商品信息Controller
 * @author	libingbin2015@aliyun.com
 * @date	2016年9月15日下午11:43:51
 * @version 1.0
 */
@Controller
@RequestMapping("/item")
public class ItemController {

	@Autowired
	private ItemService itemService;
	
	@RequestMapping("/info/{itemId}")
	@ResponseBody
	public BladeResult getItemBaseInfo(@PathVariable Long itemId) {
		BladeResult result = itemService.getItemBaseInfo(itemId);
		return result;
	}
	
	@RequestMapping("/desc/{itemId}")
	@ResponseBody
	public BladeResult getItemDesc(@PathVariable Long itemId) {
		BladeResult result = itemService.getItemDesc(itemId);
		return result;
	}
	
	@RequestMapping("/param/{itemId}")
	@ResponseBody
	public BladeResult getItemParam(@PathVariable Long itemId) {
		BladeResult result = itemService.getItemParam(itemId);
		return result;
	}
}

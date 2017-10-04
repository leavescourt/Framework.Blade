package com.bingbinlee.blade.controller;


import com.bingbinlee.blade.common.pojo.BladeResult;
import com.bingbinlee.blade.common.pojo.EUDataGridResult;
import com.bingbinlee.blade.pojo.TbItem;
import com.bingbinlee.blade.service.impl.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 商品管理Controller
 * @author	libingbin2015@aliyun.com
 * @date	2016年10月1日下午9:11:51
 * @version 1.0
 */

@Controller
public class ItemController {

	@Autowired
	private ItemService itemService;
	
	@RequestMapping("/item/{itemId}")
	@ResponseBody
	public TbItem getItemById(@PathVariable Long itemId) {
		TbItem tbItem = itemService.getItemById(itemId);
		return tbItem;
	}
	
	@RequestMapping("/item/list")
	@ResponseBody
	public EUDataGridResult getItemList(Integer page, Integer rows) {
		EUDataGridResult result = itemService.getItemList(page, rows);
		return result;
	}
	
	@RequestMapping(value="/item/save", method=RequestMethod.POST)
	@ResponseBody
	private BladeResult createItem(TbItem item, String desc, String itemParams) throws Exception {
		BladeResult result = itemService.createItem(item, desc, itemParams);
		return result;
	}
}

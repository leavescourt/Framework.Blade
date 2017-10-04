package com.bingbinlee.blade.search.controller;


import com.bingbinlee.blade.common.pojo.BladeResult;
import com.bingbinlee.blade.common.utils.ExceptionUtil;
import com.bingbinlee.blade.search.pojo.SearchResult;
import com.bingbinlee.blade.search.service.SearchService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 商品查询Controller
 * @author	libingbin2015@aliyun.com
 * @date	2016年10月1日下午9:11:51
 * @version 1.0
 */
@Controller
public class SearchController {

	@Autowired
	private SearchService searchService;
	
	@RequestMapping(value="/query", method=RequestMethod.GET)
	@ResponseBody
	public BladeResult search(@RequestParam("q")String queryString,
							  @RequestParam(defaultValue="1")Integer page,
							  @RequestParam(defaultValue="60")Integer rows) {
		//查询条件不能为空
		if (StringUtils.isBlank(queryString)) {
			return BladeResult.build(400, "查询条件不能为空");
		}
		SearchResult searchResult = null;
		try {
			queryString = new String(queryString.getBytes("iso8859-1"), "utf-8");
			searchResult = searchService.search(queryString, page, rows);
		} catch (Exception e) {
			e.printStackTrace();
			return BladeResult.build(500, ExceptionUtil.getStackTrace(e));
		}
		return BladeResult.ok(searchResult);
		
	}
	
}

package com.bingbinlee.blade.portal.service.impl;


import com.bingbinlee.blade.common.pojo.BladeResult;
import com.bingbinlee.blade.common.utils.HttpClientUtil;
import com.bingbinlee.blade.portal.pojo.SearchResult;
import com.bingbinlee.blade.portal.service.SearchService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * 商品搜索Service
 * @author	libingbin2015@aliyun.com
 * @date	2016年10月1日下午9:11:51
 * @version 1.0
 */

@Service
public class SearchServiceImpl implements SearchService {

	@Value("${SEARCH_BASE_URL}")
	private String SEARCH_BASE_URL;
	
	@Override
	public SearchResult search(String queryString, int page) {
		// 调用taotao-search的服务
		//查询参数
		Map<String, String> param = new HashMap<>();
		param.put("q", queryString);
		param.put("page", page + "");
		try {
			//调用服务
			String json = HttpClientUtil.doGet(SEARCH_BASE_URL, param);
			//把字符串转换成java对象
			BladeResult bladeResult = BladeResult.formatToPojo(json, SearchResult.class);
			if (bladeResult.getStatus() == 200) {
				SearchResult result = (SearchResult) bladeResult.getData();
				return result;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}

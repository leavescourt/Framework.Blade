package com.bingbinlee.blade.portal.service.impl;

import com.bingbinlee.blade.common.pojo.BladeResult;
import com.bingbinlee.blade.common.utils.HttpClientUtil;
import com.bingbinlee.blade.common.utils.JsonUtils;
import com.bingbinlee.blade.portal.pojo.Order;
import com.bingbinlee.blade.portal.service.OrderService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * 订单处理Service
 * @author	libingbin2015@aliyun.com
 * @date	2016年10月1日下午9:11:51
 * @version 1.0
 */
@Service
public class OrderServiceImpl implements OrderService {
	
	@Value("${ORDER_BASE_URL}")
	private String ORDER_BASE_URL;
	@Value("${ORDER_CREATE_URL}")
	private String ORDER_CREATE_URL;
	

	@Override
	public String createOrder(Order order) {
		//调用创建订单服务之前补全用户信息。
		//从cookie中后取TT_TOKEN的内容，根据token调用sso系统的服务根据token换取用户信息。
		
		//调用taotao-order的服务提交订单。
		String json = HttpClientUtil.doPostJson(ORDER_BASE_URL + ORDER_CREATE_URL, JsonUtils.objectToJson(order));
		//把json转换成BladeResult
		BladeResult bladeResult = BladeResult.format(json);
		if (bladeResult.getStatus() == 200) {
			Object orderId = bladeResult.getData();
			return orderId.toString();
		}
		return "";
	}

}
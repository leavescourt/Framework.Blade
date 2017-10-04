package com.bingbinlee.blade.order.controller;


import com.bingbinlee.blade.common.pojo.BladeResult;
import com.bingbinlee.blade.common.utils.ExceptionUtil;
import com.bingbinlee.blade.order.pojo.Order;
import com.bingbinlee.blade.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 订单Controller
 * @author	libingbin2015@aliyun.com
 * @date	2016年10月1日下午9:11:51
 * @version 1.0
 */
@Controller
public class OrderController {

	@Autowired
	private OrderService orderService;
	
	@RequestMapping(value="/create", method=RequestMethod.POST)
	@ResponseBody
	public BladeResult createOrder(@RequestBody Order order) {
		try {
			BladeResult result = orderService.createOrder(order, order.getOrderItems(), order.getOrderShipping());
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			return BladeResult.build(500, ExceptionUtil.getStackTrace(e));
		}
	}
}

package com.bingbinlee.blade.portal.pojo;


import com.bingbinlee.blade.pojo.TbOrder;
import com.bingbinlee.blade.pojo.TbOrderItem;
import com.bingbinlee.blade.pojo.TbOrderShipping;

import java.util.List;

public class Order extends TbOrder {

	private List<TbOrderItem> orderItems;
	private TbOrderShipping orderShipping;
	public List<TbOrderItem> getOrderItems() {
		return orderItems;
	}
	public void setOrderItems(List<TbOrderItem> orderItems) {
		this.orderItems = orderItems;
	}
	public TbOrderShipping getOrderShipping() {
		return orderShipping;
	}
	public void setOrderShipping(TbOrderShipping orderShipping) {
		this.orderShipping = orderShipping;
	}
	
	
}

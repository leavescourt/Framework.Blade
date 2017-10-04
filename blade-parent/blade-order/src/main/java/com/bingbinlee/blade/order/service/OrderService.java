package com.bingbinlee.blade.order.service;


import com.bingbinlee.blade.common.pojo.BladeResult;
import com.bingbinlee.blade.pojo.TbOrder;
import com.bingbinlee.blade.pojo.TbOrderItem;
import com.bingbinlee.blade.pojo.TbOrderShipping;

import java.util.List;

public interface OrderService {

	BladeResult createOrder(TbOrder order, List<TbOrderItem> itemList, TbOrderShipping orderShipping);
}

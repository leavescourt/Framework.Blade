package com.bingbinlee.blade.portal.service;


import com.bingbinlee.blade.common.pojo.BladeResult;
import com.bingbinlee.blade.portal.pojo.CartItem;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public interface CartService {

	BladeResult addCartItem(long itemId, int num, HttpServletRequest request, HttpServletResponse response);
	List<CartItem> getCartItemList(HttpServletRequest request, HttpServletResponse response);
	BladeResult deleteCartItem(long itemId, HttpServletRequest request, HttpServletResponse response);
}

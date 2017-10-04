package com.bingbinlee.blade.rest.service;


import com.bingbinlee.blade.common.pojo.BladeResult;

public interface ItemService {

	BladeResult getItemBaseInfo(long itemId);
	BladeResult getItemDesc(long itemId);
	BladeResult getItemParam(long itemId);
}

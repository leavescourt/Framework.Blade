package com.bingbinlee.blade.service.impl;

import com.bingbinlee.blade.common.pojo.BladeResult;
import com.bingbinlee.blade.common.pojo.EUDataGridResult;
import com.bingbinlee.blade.pojo.TbItem;

public interface ItemService {

	TbItem getItemById(long itemId);
	EUDataGridResult getItemList(int page, int rows);
	BladeResult createItem(TbItem item, String desc, String itemParam) throws Exception;
}

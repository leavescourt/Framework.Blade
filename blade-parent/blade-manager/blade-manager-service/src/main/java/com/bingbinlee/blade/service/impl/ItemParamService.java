package com.bingbinlee.blade.service.impl;

import com.bingbinlee.blade.common.pojo.BladeResult;
import com.bingbinlee.blade.pojo.TbItemParam;


public interface ItemParamService {

	BladeResult getItemParamByCid(long cid);
	BladeResult insertItemParam(TbItemParam itemParam);
}

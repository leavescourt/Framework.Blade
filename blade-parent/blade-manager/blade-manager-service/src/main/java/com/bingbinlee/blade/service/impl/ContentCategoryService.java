package com.bingbinlee.blade.service.impl;


import com.bingbinlee.blade.common.pojo.BladeResult;
import com.bingbinlee.blade.common.pojo.EUTreeNode;

import java.util.List;

public interface ContentCategoryService {

	List<EUTreeNode> getCategoryList(long parentId);
	BladeResult insertContentCategory(long parentId, String name);
}

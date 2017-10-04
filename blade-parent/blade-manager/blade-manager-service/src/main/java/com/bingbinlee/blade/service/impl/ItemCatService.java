package com.bingbinlee.blade.service.impl;


import com.bingbinlee.blade.common.pojo.EUTreeNode;

import java.util.List;

public interface ItemCatService {

	List<EUTreeNode> getCatList(long parentId);
}

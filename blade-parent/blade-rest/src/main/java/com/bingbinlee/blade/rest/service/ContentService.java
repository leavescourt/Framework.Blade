package com.bingbinlee.blade.rest.service;


import com.bingbinlee.blade.pojo.TbContent;

import java.util.List;

public interface ContentService {

	List<TbContent> getContentList(long contentCid);
}

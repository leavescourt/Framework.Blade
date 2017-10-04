package com.bingbinlee.blade.rest.service;


import com.bingbinlee.blade.common.pojo.BladeResult;

public interface RedisService {

	BladeResult syncContent(long contentCid);
}

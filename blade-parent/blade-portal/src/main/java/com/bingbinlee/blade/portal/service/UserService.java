package com.bingbinlee.blade.portal.service;


import com.bingbinlee.blade.pojo.TbUser;

public interface UserService {

	TbUser getUserByToken(String token);
}

package com.bingbinlee.blade.sso.service;

import com.bingbinlee.blade.common.pojo.BladeResult;
import com.bingbinlee.blade.pojo.TbUser;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Description 用户管理Service
 * @author	libingbin2015@aliyun.com
 * @date	2016年11月14日上午10:28:39
 * @version 1.0
 */
public interface UserService {

	BladeResult checkData(String content, Integer type);
	BladeResult createUser(TbUser user);
	BladeResult userLogin(String username, String password, HttpServletRequest request, HttpServletResponse response);
	BladeResult getUserByToken(String token);
}

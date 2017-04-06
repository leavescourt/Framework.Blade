package com.bingbinlee.blade.portal.service;

import com.bingbinlee.blade.pojo.User;

/**
 * @Description 用户管理Service接口
 * @author	libingbin2015@aliyun.com
 * @date	2015年11月30日下午11:51:53
 * @version 1.0
 */
public interface UserService {

	User getUserByToken(String token);
}

package com.bingbinlee.blade.mapper;


import com.bingbinlee.blade.pojo.User;
import com.bingbinlee.blade.pojo.UserExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @Description UserMapper
 * @author	libingbin2015@aliyun.com
 * @date	2016年8月15日下午11:40:53
 * @version 1.0
 */
public interface UserMapper {
    int countByExample(UserExample example);

    int deleteByExample(UserExample example);

    int deleteByPrimaryKey(Long id);

    int insert(User record);

    int insertSelective(User record);

    List<User> selectByExample(UserExample example);

    User selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") User record, @Param("example") UserExample example);

    int updateByExample(@Param("record") User record, @Param("example") UserExample example);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}
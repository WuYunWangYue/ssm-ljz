package com.ljz.dao;

import com.ljz.model.User;

import java.util.List;


public interface IUserDao {
    User selectByPrimaryKey(Integer id);

    List<User> selectByName(String userName);

    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

}
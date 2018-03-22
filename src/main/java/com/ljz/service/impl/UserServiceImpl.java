package com.ljz.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ljz.dao.IUserDao;
import com.ljz.model.User;
import com.ljz.service.IUserService;

import java.util.List;

@Service("userService")
public class UserServiceImpl implements IUserService {
    @Autowired
    private IUserDao userDao;

    public User getUserById(int userId) {
        // TODO Auto-generated method stub  
        return this.userDao.selectByPrimaryKey(userId);
    }

    public List<User> getUserByUserName(String userName) {
        return userDao.selectByName(userName);
    }

    public int create(User user) {
        return userDao.insert(user);
    }

}  

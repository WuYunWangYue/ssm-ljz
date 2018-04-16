package com.ljz.service;

import com.ljz.model.User;

import java.util.List;

public interface IUserService {
    User getUserById(int userId);

    List<User> getUserByUserName(String userName);

    int create(User user);
}  
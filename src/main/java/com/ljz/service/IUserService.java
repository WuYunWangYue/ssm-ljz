package com.ljz.service;

import com.ljz.model.User;

public interface IUserService {
    User getUserById(int userId);

    int create(User user);
}  
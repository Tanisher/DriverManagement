package com.logistics.service;

import com.logistics.entity.User;

import java.util.List;

public interface UserService {

    User registerUser(User user);

    User findByUsername(String username);
    List<User> findAllUsers();
}

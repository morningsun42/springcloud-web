package com.example.dao;

import com.example.entity.User;

public interface UserDao {
    User findByUsername(String username);

    User save(User user);
}

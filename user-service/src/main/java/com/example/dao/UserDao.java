package com.example.dao;

import com.example.entity.User;

import java.util.List;
import java.util.Map;

public interface UserDao {
    User save(User user);

    User findByUsername(String username);

    List<User> findUsers();

    boolean removeByUsername(String username);
}

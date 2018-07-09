package com.example.dao;

import com.example.entity.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserDaoImpl implements UserDao {

    static List<User> userlist = new ArrayList<>();
    @Override
    public User findByUsername(String username) {
        for (User user : userlist) {
            if (user.getUsername().equals(username)) {
                return user;
            }
        }
        return null;
    }

    @Override
    public User save(User user) {
        userlist.add(user);
        return user;
    }
}

package com.example.dao;

import com.example.entity.User;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Repository
public class UserDaoImpl implements UserDao {
    static List<User> userlist = new ArrayList<>();

    @Override
    public User save(User user) {
        if (findByUsername(user.getUsername()) != null)
            return null;
        userlist.add(user);
        return user;
    }

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
    public List<User> findUsers() {
        return userlist;
    }

    @Override
    public boolean removeByUsername(String username) {
        userlist.removeIf(new Predicate<User>() {
            @Override
            public boolean test(User user) {
                return user.getUsername().equals(username);
            }
        });
        return true;
    }
}

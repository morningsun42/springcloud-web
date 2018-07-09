package com.example.service;

import com.example.dao.UserDaoImpl;
import com.example.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class UserServiceDetail implements UserDetailsService {
    // 查询用户使用
    @Autowired
    UserDaoImpl userDao;

    @Override
    public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
        // 通过用户名获取用户信息
        User user = userDao.findByUsername(name);
        if (user != null) {
            return user;
        } else {
            throw new UsernameNotFoundException("用户[" + name + "]不存在");
        }
    }

    public User createUser(User user) {
        return userDao.save(user);
    }
}

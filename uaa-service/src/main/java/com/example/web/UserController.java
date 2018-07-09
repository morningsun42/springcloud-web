package com.example.web;

import com.example.entity.User;
import com.example.service.UserServiceDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/uaa")
public class UserController {
    @Autowired
    UserServiceDetail userServiceDetail;

    @PostMapping(value = "/adduser")
    public User createUser(@RequestBody User user) {
        return userServiceDetail.createUser(user);
    }

    @GetMapping(value = "/getuser")
    public String getUser() {
        return "name";
    }
}

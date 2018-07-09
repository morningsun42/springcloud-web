package com.example.client.hystrix;

import com.example.client.UserServiceClient;
import com.example.dto.MVCResult;
import com.example.entity.User;
import org.springframework.stereotype.Component;

@Component
public class UserServiceHystrix implements UserServiceClient {
    @Override
    public MVCResult<User> getUser(String token, String username) {
        System.out.println(token);
        System.out.println(username);
        System.out.println("--------opps getUser hystrix---------");
        return null;
    }
}

package com.example.client.hystrix;

import com.example.client.UaaServiceClient;
import com.example.entity.User;
import org.springframework.stereotype.Component;

import java.util.Map;
@Component
public class UaaServiceHystrix implements UaaServiceClient {
    @Override
    public User addUser(User user) {
        System.out.println("--------opps addUser hystrix---------");
        return null;
    }
}

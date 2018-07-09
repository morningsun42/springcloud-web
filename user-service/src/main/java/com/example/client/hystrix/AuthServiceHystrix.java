package com.example.client.hystrix;

import com.example.client.AuthServiceClient;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class AuthServiceHystrix implements AuthServiceClient {
    @Override
    public Map<String, Object> getToken(String authorization, String type, String username, String password) {
        System.out.println("--------opps getToken hystrix---------");
        return null;
    }
}

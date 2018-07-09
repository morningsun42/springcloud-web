package com.example.client;

import com.example.client.hystrix.UserServiceHystrix;
import com.example.dto.MVCResult;
import com.example.entity.User;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;

@FeignClient(value = "user-service", fallback = UserServiceHystrix.class)
public interface UserServiceClient {
    @PostMapping(value = "/user/{username}")
    MVCResult<User> getUser(@RequestHeader(value = "Authorization") String token, @PathVariable("username") String username);
}

package com.example.client;

import com.example.client.hystrix.AuthServiceHystrix;
import com.example.client.hystrix.UaaServiceHystrix;
import com.example.entity.User;
import feign.Headers;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@FeignClient(value = "uaa-service", fallback = UaaServiceHystrix.class)
public interface UaaServiceClient {
    @PostMapping(value = "/uaa/adduser")
    @Headers("Content-Type: application/json")
    User addUser(@RequestBody User user);
}

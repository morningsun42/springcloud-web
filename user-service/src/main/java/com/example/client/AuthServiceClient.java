package com.example.client;

import com.example.client.hystrix.AuthServiceHystrix;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

@FeignClient(value = "uaa-service",fallback =AuthServiceHystrix.class )
public interface AuthServiceClient {
    @PostMapping(value = "/oauth/token")
    Map<String,Object> getToken(@RequestHeader(value = "Authorization") String authorization, @RequestParam("grant_type") String type,
                                @RequestParam("username") String username, @RequestParam("password") String password);
}

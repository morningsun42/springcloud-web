package com.example.web;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/zipkin")
public class ZipkinController {
    @Value("${server.port}")
    String port;

    @RequestMapping(value = "/port")
    public String port() {
        return port;
    }
}

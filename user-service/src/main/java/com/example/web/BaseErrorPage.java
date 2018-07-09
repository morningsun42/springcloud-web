package com.example.web;

import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BaseErrorPage implements ErrorController {
    @Override
    public String getErrorPath() {
        return "";
    }

    @RequestMapping("/{code}")
    public String errorHtml(@PathVariable("code") String code) {
        return "/" + code;
    }
}

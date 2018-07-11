package com.example.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import springfox.documentation.annotations.ApiIgnore;

@ApiIgnore
@Controller
@RequestMapping("/user")
public class ViewController {

    @RequestMapping("/")
    public String root() {
        return "redirect:user/login";
    }

    @RequestMapping("/view-login")
    public String login() {
        return "user/login";
    }

    @RequestMapping("/view-registry")
    public String registry() {
        return "user/registry";
    }

    @RequestMapping("/view-userlist")
    public String userlist() {
        return "user/userlist";
    }
}

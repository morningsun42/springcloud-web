package com.example.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/book")
public class ViewController {
    @RequestMapping("/view-addbook")
    public String addbook() {
        return "book/addbook";
    }

    @RequestMapping("/view-booklist")
    public String booklist() {
        return "book/booklist";
    }
}

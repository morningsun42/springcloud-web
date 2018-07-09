package com.example.web;

import com.example.dto.MVCResult;
import com.example.service.BookService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/book")
public class BookController {
    @Autowired
    BookService bookService;

    @ApiOperation(value = "保存图书信息", notes = "保存图书信息")
    @PreAuthorize("hasRole('USER')")
    @PostMapping("addbook")
    public MVCResult addbook(@RequestBody Map<String, Object> book) {
        return MVCResult.create(bookService.saveBook(book));
    }

    @ApiOperation(value = "根据用户id获取所有的book", notes = "根据用户id获取所有的book")
    @PreAuthorize("hasAuthority('ROLE_USER')")
    @GetMapping("/{username}")
    public MVCResult getBooksByUsername(@PathVariable String username) {
        return MVCResult.create(bookService.findBooksByUsername(username));
    }
}

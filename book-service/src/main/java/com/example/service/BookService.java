package com.example.service;

import com.example.client.UserServiceClient;
import com.example.dao.BookDao;
import com.example.dto.MVCResult;
import com.example.entity.User;
import com.example.utils.UserUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class BookService {
    @Autowired
    private BookDao bookDaoImpl;

    @Autowired
    private UserServiceClient userServiceHystrix;

    public MVCResult saveBook(Map<String, Object> book) {

        return MVCResult.create(bookDaoImpl.saveBook(book));
    }

    public MVCResult findBooksByUsername(String username) {
        Map<String, Object> dto = new HashMap<>();
        List<?> books = bookDaoImpl.findBooksByUsername(username);
        MVCResult user = userServiceHystrix.getUser(UserUtils.getCurrentToken(), username);
        dto.put("user", user.data);
        dto.put("books", books);
        return MVCResult.create(dto);
    }
}

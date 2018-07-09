package com.example.dao;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Repository
public class BookDaoImpl implements BookDao {
    static List<Map<String, Object>> booklist = new ArrayList<>();

    @Override
    public boolean saveBook(Map<String, Object> book) {

        return booklist.add(book);
    }

    @Override
    public List<Map<String, Object>> findBooksByUsername(String username) {
        return booklist.stream().filter(book -> {
            return book.get("username").equals(username);
        }).collect(Collectors.toList());
    }
}

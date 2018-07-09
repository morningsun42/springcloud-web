package com.example.dao;

import java.util.List;
import java.util.Map;

public interface BookDao {
    boolean saveBook(Map<String, Object> book);

    List<Map<String, Object>> findBooksByUsername(String username);
}

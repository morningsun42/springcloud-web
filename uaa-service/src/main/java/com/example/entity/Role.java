package com.example.entity;

import org.springframework.security.core.GrantedAuthority;

public class Role implements GrantedAuthority {

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;

    @Override
    public String getAuthority() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }
}


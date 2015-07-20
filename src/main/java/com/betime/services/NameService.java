package com.betime.services;

import org.springframework.stereotype.Service;

@Service
public class NameService {

    public void setName(String name) {
        this.name = name;
    }

    private String name;

    public String getName() {
        return name;
    }

    public String getAgeMessage(Integer age) {
        if (age <= 25) {
            return "You are so young";
        }
        return "You are too old";
    }
}

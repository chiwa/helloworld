package com.betime.services;

import org.springframework.stereotype.Service;

@Service
public class NameService {

    public String getName() {
        return "Chiwa Kantawong";
    }

    public String getAgeMessage(Integer age) {
        if (age <= 25) {
            return "You are so young";
        }
        return "You are too old";
    }
}

package com.betime.controllers;


import com.betime.services.NameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@Controller
public class MainController {

    @Autowired
    private NameService nameService;

    @RequestMapping(value = "/index.html")
    public String index() {
        return "index";
    }

    @RequestMapping(value = "/hello.html")
    public String hello(Model model, @RequestParam("age") int age) {
        String name = nameService.getName();
        String message = nameService.getAgeMessage(age);
        model.addAttribute("name" , name);
        model.addAttribute("age", age);
        model.addAttribute("message" , message);
        return "hello";
    }

}

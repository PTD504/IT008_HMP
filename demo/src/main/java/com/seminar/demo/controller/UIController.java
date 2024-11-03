package com.seminar.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@Controller
public class UIController { 
    @GetMapping("/ui/{path}")
    public String getMethodName(@PathVariable String path) {
        return path;
    }
    

}

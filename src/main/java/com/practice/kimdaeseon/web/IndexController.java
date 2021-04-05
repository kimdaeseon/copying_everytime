package com.practice.kimdaeseon.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;

import lombok.RequiredArgsConstructor;

import javax.servlet.http.HttpSession;

@RequiredArgsConstructor
@Controller
public class IndexController {

    @GetMapping("/")
    public String index(Model model){
        return "index";
    }

    @GetMapping("/post/save")
    public String postSave(){
        return "post-save";
    }
}

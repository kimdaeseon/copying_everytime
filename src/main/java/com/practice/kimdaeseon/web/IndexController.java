package com.practice.kimdaeseon.web;

import com.practice.kimdaeseon.service.post.PostService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;

import lombok.RequiredArgsConstructor;

import javax.servlet.http.HttpSession;

@RequiredArgsConstructor
@Controller
public class IndexController {

    final public PostService postService;

    @GetMapping("/")
    public String index(Model model){
        model.addAttribute("post", postService.findAllPost());
        return "index";
    }

    @GetMapping("/post/save")
    public String postSave(){
        return "post-save";
    }
}

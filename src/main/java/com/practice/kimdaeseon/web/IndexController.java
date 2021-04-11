package com.practice.kimdaeseon.web;

import com.practice.kimdaeseon.service.board.BoardService;
import com.practice.kimdaeseon.service.post.PostService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller
public class IndexController {

    final public PostService postService;
    final public BoardService boardService;
    @GetMapping("/")
    public String home(Model model){
        return "home";
    }

    @GetMapping("/board_list")
    public String boards(Model model){
        model.addAttribute("board_list", boardService.findAllBoard());
        return "board_list";
    }

    @GetMapping("/boards/{boardName}")
    public String index(@PathVariable String boardName, Model model){
        model.addAttribute("post", postService.findPostByBoardName(boardName));
        model.addAttribute("board", boardName);
        return "index";
    }

    @GetMapping("/{boardName}/post/save")
    public String postSave(@PathVariable String boardName, Model model){
        model.addAttribute("board", boardName);
        return "post-save";
    }

    @GetMapping("/board/save")
    public String boardSave(Model model){
        return "board-save";
    }
}

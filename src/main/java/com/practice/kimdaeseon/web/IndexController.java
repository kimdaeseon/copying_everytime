package com.practice.kimdaeseon.web;

import com.practice.kimdaeseon.service.board.BoardService;
import com.practice.kimdaeseon.service.post.PostService;
import com.practice.kimdaeseon.service.schedule.ScheduleService;
import com.practice.kimdaeseon.service.subject.SubjectService;
import com.practice.kimdaeseon.web.dto.PostListResponseDto;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Controller
public class IndexController {

    final public PostService postService;
    final public BoardService boardService;
    final public ScheduleService scheduleService;
    final public SubjectService subjectService;
    @GetMapping("/")
    public String home(Model model){
        return "home";
    }

    @GetMapping("/board_list")
    public String boards(Model model){
        model.addAttribute("board_list", boardService.findAllBoardAt(0));
        model.addAttribute("number_of_board", boardService.getBoardSizeToList());
        return "board_list";
    }
    @GetMapping("/board_list/{boardNumber}")
    public String boardsAt(@PathVariable int boardNumber, Model model){
        model.addAttribute("board_list", boardService.findAllBoardAt(boardNumber-1));
        model.addAttribute("number_of_board", boardService.getBoardSizeToList());
        return "board_list";
    }

    @GetMapping("/boards/{boardName}")
    public String index(@PathVariable String boardName, Model model){
        List<PostListResponseDto> list = postService.findAllPostAt(0, boardName);
        System.out.println(list.get(0).toString());
        model.addAttribute("post", postService.findAllPostAt(0, boardName));
        model.addAttribute("board", boardName);
        model.addAttribute("number_of_post", postService.getPostSizeToList(boardName));

        return "index";
    }

    @GetMapping("/boards/{boardName}/{postNumber}")
    public String indexAt(@PathVariable String boardName, @PathVariable int postNumber, Model model){
        model.addAttribute("post", postService.findAllPostAt(postNumber - 1,boardName));
        model.addAttribute("board", boardName);
        model.addAttribute("number_of_post", postService.getPostSizeToList(boardName));

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

    @GetMapping("/schedule_list")
    public String scheduleList(Model model){
        model.addAttribute("schedule_list", scheduleService.findAllScheduleAt(0));
        model.addAttribute("number_of_schedule", scheduleService.getScheduleSize());
        return "schedule_list";
    }
    @GetMapping("/schedule_list/{scheduleNumber}")
    public String scheduleList(@PathVariable int scheduleNumber,  Model model){
        model.addAttribute("schedule_list", scheduleService.findAllScheduleAt(scheduleNumber - 1));
        model.addAttribute("number_of_schedule", scheduleService.getScheduleSize());
        return "schedule_list";
    }

    @GetMapping("/schedule/save")
    public String scheduleSave(Model model){
        return "schedule_save";
    }

    @GetMapping("/schedule/{scheduleName}")
    public String schedule(@PathVariable String scheduleName,Model model){
        model.addAttribute("Schedule", scheduleName);
        model.addAttribute("Subject", subjectService.findAllSubject());
        return "schedule";
    }

}

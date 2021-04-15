package com.practice.kimdaeseon.web;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@Controller
public class ScheduleController {

    @GetMapping("/schedule")
    public String scheduleList(Model model){
        model.addAttribute("schedule_list", null);
        model.addAttribute("number_of_schedule", 1);
        return "schedule_list";
    }
}

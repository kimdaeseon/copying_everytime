package com.practice.kimdaeseon.web;

import com.practice.kimdaeseon.service.schedule.ScheduleService;
import com.practice.kimdaeseon.web.dto.ScheduleSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class ScheduleController {

    private final ScheduleService scheduleService;

    @PostMapping("/api/v1/schedule/save")
    public Long save(@RequestBody ScheduleSaveRequestDto scheduleSaveRequestDto){
        return scheduleService.save(scheduleSaveRequestDto);
    }
}

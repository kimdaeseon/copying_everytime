package com.practice.kimdaeseon.web.dto;

import com.practice.kimdaeseon.domain.schedule.Schedule;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
public class ScheduleListResponseDto {
    private Long id;
    private String name;
    private LocalDateTime modifiedDate;

    public ScheduleListResponseDto(Schedule entity){
        this.id = entity.getId();
        this.name = entity.getName();
        this.modifiedDate = entity.getModifiedDate();
    }
}

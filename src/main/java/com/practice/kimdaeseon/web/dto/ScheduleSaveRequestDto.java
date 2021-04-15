package com.practice.kimdaeseon.web.dto;

import com.practice.kimdaeseon.domain.schedule.Schedule;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class ScheduleSaveRequestDto {
    private String name;

    @Builder
    public ScheduleSaveRequestDto(String name){
        this.name = name;
    }

    public Schedule toEntity(){
        return  Schedule.builder().name(this.name).build();
    }
}

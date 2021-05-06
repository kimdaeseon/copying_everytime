package com.practice.kimdaeseon.web.dto;

import com.practice.kimdaeseon.domain.scheduleData.ScheduleData;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ScheduleDataListResponseDto {
    private String name;
    private Long startTime;
    private Long finishTime;
    private Long credit;
    private String day;

    @Builder
    public ScheduleDataListResponseDto(String name, Long startTime, Long finishTime, Long credit, String day){
        this.name = name;
        this.startTime = startTime;
        this.finishTime = finishTime;
        this.credit = credit;
        this.day = day;
    }
}

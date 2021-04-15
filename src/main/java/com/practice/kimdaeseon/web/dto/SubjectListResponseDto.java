package com.practice.kimdaeseon.web.dto;

import com.practice.kimdaeseon.domain.subject.Subject;
import lombok.Getter;

@Getter
public class SubjectListResponseDto {
    private Long id;
    private String name;
    private Long startTime;
    private Long finishTime;
    private Long credit;

    public SubjectListResponseDto(Subject entity){
        this.id = entity.getId();
        this.name = entity.getName();
        this.startTime = entity.getStartTime();
        this.finishTime = entity.getFinishTime();
        this.credit = entity.getCredit();
    }
}

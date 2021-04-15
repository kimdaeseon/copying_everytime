package com.practice.kimdaeseon.web.dto;

import com.practice.kimdaeseon.domain.subject.Subject;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class SubjectSaveRequestDto {
    private String name;
    private Long startTime;
    private Long finishTime;
    private Long credit;

    @Builder
    public SubjectSaveRequestDto(String name, Long startTime, Long finishTime, Long credit){
        this.name = name;
        this.startTime = startTime;
        this.finishTime = finishTime;
        this.credit = credit;
    }

    public Subject toEntity(){
        return Subject.builder().name(this.name).startTime(this.startTime).finishTime(this.finishTime).credit(this.credit).build();
    }
}

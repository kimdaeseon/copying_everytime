package com.practice.kimdaeseon.web.dto;

import com.practice.kimdaeseon.domain.scheduleData.ScheduleData;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@Getter
public class ScheduleDataSaveRequestDto {
    private String scheduleName;
    private String userName;
    private String subjectName;

    @Builder
    public ScheduleDataSaveRequestDto(ScheduleData entity){
        this.scheduleName = entity.getScheduleName();
        this.userName = entity.getUserName();
        this.subjectName = entity.getSubjectName();
    }

    public ScheduleData toEntity(){
        return ScheduleData.builder().scheduleName(this.scheduleName).userName(this.userName).subjectName(this.subjectName).build();
    }
}

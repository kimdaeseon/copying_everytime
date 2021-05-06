package com.practice.kimdaeseon.domain.scheduleData;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Entity
public class ScheduleData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100)
    private String scheduleName;

    @Column(length = 100)
    private String userName;

    @Column(length = 100)
    private String subjectName;


    @Builder
    public ScheduleData(String scheduleName, String userName, String subjectName) {
        this.scheduleName = scheduleName;
        this.userName = userName;
        this.subjectName = subjectName;
    }
}

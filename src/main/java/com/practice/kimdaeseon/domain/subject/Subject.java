package com.practice.kimdaeseon.domain.subject;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Entity
public class Subject {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String name;

    private Long startTime; // 00시00분 = 0000 ex) 13시 30분 = 1330

    private Long finishTime;

    private Long credit;

    private String day;

    @Builder
    public Subject(String name, Long startTime, Long finishTime, Long credit, String day){
        this.name = name;
        this.startTime = startTime;
        this.finishTime = finishTime;
        this.credit = credit;
        this.day = day;
    }
}

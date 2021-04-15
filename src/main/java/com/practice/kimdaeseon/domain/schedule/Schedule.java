package com.practice.kimdaeseon.domain.schedule;

import com.practice.kimdaeseon.domain.BaseTimeEntity;
import lombok.Getter;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Entity
public class Schedule extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private String name;

    @Builder
    public Schedule(String name){
        this.name = name;
    }
}

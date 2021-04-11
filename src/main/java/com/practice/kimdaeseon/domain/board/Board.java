package com.practice.kimdaeseon.domain.board;

import lombok.Getter;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor
@Entity
@Getter
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "BOARD_ID")
    private Long id;

    @Column(name="BOARD_NAME",nullable = false, length = 100, unique = true)
    private String name;

    @Builder
    public Board(String name){
        this.name = name;
    }
}

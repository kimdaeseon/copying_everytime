package com.practice.kimdaeseon.web.dto;

import com.practice.kimdaeseon.domain.board.Board;
import lombok.Getter;

@Getter
public class BoardListResponseDto {
    private Long id;
    private String name;

    public BoardListResponseDto(Board entity){
        this.id = entity.getId();
        this.name = entity.getName();
    }
}

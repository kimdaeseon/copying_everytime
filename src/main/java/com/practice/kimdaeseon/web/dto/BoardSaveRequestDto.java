package com.practice.kimdaeseon.web.dto;

import com.practice.kimdaeseon.domain.board.Board;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Builder;

@NoArgsConstructor
@Getter
public class BoardSaveRequestDto {
    private String name;

    @Builder
    public BoardSaveRequestDto(Long id, String board_name){
        this.name = board_name;
    }

    public Board toEntity(){
        return Board.builder().name(name).build();
    }
}

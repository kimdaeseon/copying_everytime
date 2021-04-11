package com.practice.kimdaeseon.web;


import com.practice.kimdaeseon.service.board.BoardService;
import com.practice.kimdaeseon.web.dto.BoardSaveRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
public class BoardController {

    private final BoardService boardService;

    @PostMapping("/api/v1/board/save")
    public Long save(@RequestBody BoardSaveRequestDto boardSaveRequestDto){
        return boardService.save(boardSaveRequestDto);
    }

}

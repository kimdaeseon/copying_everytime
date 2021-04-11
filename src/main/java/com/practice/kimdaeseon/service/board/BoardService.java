package com.practice.kimdaeseon.service.board;

import com.practice.kimdaeseon.domain.board.BoardRepository;
import com.practice.kimdaeseon.web.dto.BoardListResponseDto;
import com.practice.kimdaeseon.web.dto.BoardSaveRequestDto;
import com.practice.kimdaeseon.web.dto.PostListResponseDto;
import com.practice.kimdaeseon.web.dto.PostSaveRequestDto;
import lombok.RequiredArgsConstructor;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class BoardService {
    final public BoardRepository boardRepository;

    @Transactional
    public Long save(BoardSaveRequestDto boardSaveRequestDto){
        return boardRepository.save(boardSaveRequestDto.toEntity()).getId();
    }
    @Transactional(readOnly = true)
    public List<BoardListResponseDto> findAllBoard(){
        return boardRepository.findAllDesc().stream().map(BoardListResponseDto::new).collect(Collectors.toList());
    }
}

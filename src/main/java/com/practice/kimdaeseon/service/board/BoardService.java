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

import java.util.ArrayList;
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
    public List<BoardListResponseDto> findAllBoardAt(int number){
        List<BoardListResponseDto> list = boardRepository.findAllDesc().stream().map(BoardListResponseDto::new).collect(Collectors.toList());
        List<BoardListResponseDto> temp = new ArrayList<>();
        int size = list.size();
        if(size >= number + 10) size = number + 10;
        for(int i = number * 10; i < size; i++){
            temp.add(list.get(i));
        }
        return temp;
    }
    public List<Integer> getBoardSizeToList(){
        List<BoardListResponseDto> list = boardRepository.findAllDesc().stream().map(BoardListResponseDto::new).collect(Collectors.toList());
        int size = list.size() / 10 + 1;
        List<Integer> temp = new ArrayList<>();
        for(int i = 1; i <= size; i++){
            temp.add(i);
        }
        return temp;
    }
}

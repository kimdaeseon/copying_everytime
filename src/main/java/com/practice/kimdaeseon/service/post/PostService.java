package com.practice.kimdaeseon.service.post;

import com.practice.kimdaeseon.domain.post.PostRepository;
import com.practice.kimdaeseon.web.dto.BoardListResponseDto;
import com.practice.kimdaeseon.web.dto.PostListResponseDto;
import com.practice.kimdaeseon.web.dto.PostSaveRequestDto;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@RequiredArgsConstructor
@Service
public class PostService {
    final private PostRepository postRepository;

    @Transactional
    public Long save(PostSaveRequestDto postSaveRequestDto){
        return postRepository.save(postSaveRequestDto.toEntity()).getId();
    }
    @Transactional(readOnly = true)
    public List<PostListResponseDto> findAllPost(){
        return postRepository.findAllDesc().stream().map(PostListResponseDto::new).collect(Collectors.toList());
    }
    public List<PostListResponseDto> findPostByBoardName(String boardName){
        return postRepository.findPostByBoardName(boardName).stream().map(PostListResponseDto::new).collect(Collectors.toList());
    }
    public List<PostListResponseDto> findAllPostAt(int number, String boardName){
        List<PostListResponseDto> list = this.findPostByBoardName(boardName);
        List<PostListResponseDto> temp = new ArrayList<>();
        int size = list.size();
        if(size >= number + 10) size = number + 10;
        for(int i = number * 10; i < size; i++){
            temp.add(list.get(i));
        }
        return temp;
    }
    public List<Integer> getPostSizeToList(String boardName){
        List<PostListResponseDto> list = this.findPostByBoardName(boardName);
        int size = list.size() / 10 + 1;
        List<Integer> temp = new ArrayList<>();
        for(int i = 1; i <= size; i++){
            temp.add(i);
        }
        return temp;
    }
}
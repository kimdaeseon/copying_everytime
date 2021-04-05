package com.practice.kimdaeseon.service.post;

import com.practice.kimdaeseon.domain.post.PostRepository;
import com.practice.kimdaeseon.web.dto.PostSaveRequestDto;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.practice.kimdaeseon.domain.post.Post;

import java.util.List;
import java.util.stream.Collector;


@RequiredArgsConstructor
@Service
public class PostService {
    private final PostRepository postRepository;

    @Transactional
    public Long save(PostSaveRequestDto postSaveRequestDto){
        return postRepository.save(postSaveRequestDto.toEntity()).getId();
    }

}
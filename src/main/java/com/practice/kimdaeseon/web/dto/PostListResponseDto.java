package com.practice.kimdaeseon.web.dto;

import com.practice.kimdaeseon.domain.post.Post;
import lombok.Getter;

@Getter
public class PostListResponseDto {

    private Long id;
    private String title;
    private String author;

    public PostListResponseDto(Post entity){
        this.id = entity.getId();
        this.title = entity.getTitle();
        this.author = entity.getAuthor();
    }
}

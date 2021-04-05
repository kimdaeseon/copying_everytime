package com.practice.kimdaeseon.web.dto;

import com.practice.kimdaeseon.domain.post.Post;
import lombok.Getter;
import lombok.Builder;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class PostSaveRequestDto {
    private String title;
    private String author;
    private String content;

    @Builder
    public PostSaveRequestDto(String title, String author, String content){
        this.title = title;
        this.author = author;
        this.content = content;
    }

    public Post toEntity(){
        return Post.builder().title(title).author(author).content(content).build();
    }
}

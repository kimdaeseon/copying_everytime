package com.practice.kimdaeseon.web.dto;

import com.practice.kimdaeseon.domain.board.Board;
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
    private String board;

    @Builder
    public PostSaveRequestDto(String title, String author, String content, String board){
        this.title = title;
        this.author = author;
        this.content = content;
        this.board = board;
    }

    public Post toEntity(){
        return Post.builder().title(title).author(author).content(content).board(board).build();
    }
}

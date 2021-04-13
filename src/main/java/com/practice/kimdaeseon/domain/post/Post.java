package com.practice.kimdaeseon.domain.post;

import com.practice.kimdaeseon.domain.BaseTimeEntity;
import lombok.Getter;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Post extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="POST_ID")
    private Long id;

    @Column(name="POST_TITLE",length = 500, nullable = false)
    private String title;

    @Column(name="POST_CONTENT",columnDefinition = "TEXT", nullable = false)
    private String content;

    @Column(name="POST_AUTHOR")
    private String author;

    @Column(name="POST_BOARD", nullable = false, length = 100)
    private String board;

    @Builder
    public Post(String title, String content, String author, String board){
        this.author = author;
        this.content = content;
        this.title = title;
        this.board = board;
    }

}

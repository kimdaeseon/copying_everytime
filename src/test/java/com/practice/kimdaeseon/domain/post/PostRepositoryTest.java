package com.practice.kimdaeseon.domain.post;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class PostRepositoryTest {
    @Autowired
    PostRepository postRepository;

    @Test
    public void post_Test(){
        String title = "title";
        String context = "context";
        String author = "author";
        postRepository.save(Post.builder().author(author).title(title).content(context).build());

        List<Post> postList = postRepository.findAll();

        Post post = postList.get(0);
        assertThat(post.getAuthor()).isEqualTo(author);
        assertThat(post.getTitle()).isEqualTo(title);
        assertThat(post.getContent()).isEqualTo(context);

    }
}

package com.example.springbootes;

import com.example.springbootes.entity.DiscussPost;
import com.example.springbootes.repository.DiscussPostRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringbootEsApplicationTests {
    @Autowired
    private DiscussPostRepository discussPostRepository;

    @Test
    void contextLoads() {
    }
    @Test
    void insert(){
        DiscussPost discussPost = new DiscussPost();
        discussPost.setUserId(1);
        discussPost.setUserId(11);
        discussPost.setTitle("dian");
        discussPostRepository.save(discussPost);
    }

}

package com.example.springbootes.repository;

import com.example.springbootes.entity.DiscussPost;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

/**
 * @Description: TODO
 * @Author wanggl
 * @Date 2024/4/6 11:39
 */
@Repository
public interface DiscussPostRepository extends ElasticsearchRepository<DiscussPost,Integer> {
}

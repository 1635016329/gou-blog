package com.gosh.goublog.service;
import com.google.common.collect.Lists;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.gosh.goublog.model.dto.post.PostQueryRequest;
import com.gosh.goublog.model.eneity.Post;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

/**
 * @author Gosh
 * @version 1.0
 * @date 2023/6/21 23:07
 * @description 使用es搜索post
 */
@SpringBootTest
public class PostSearhByEsTest {

    @Resource
    private PostService postService;

    @Test
    public void searchFromEs() {
        PostQueryRequest postQueryRequest = new PostQueryRequest();
        postQueryRequest.setSearchText("春");
        Page<Post> postPage = postService.searchFromEs(postQueryRequest);
        System.out.println(postPage);
    }
}

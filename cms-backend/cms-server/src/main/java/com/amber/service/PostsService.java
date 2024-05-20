package com.amber.service;

import com.amber.dto.posts.CreatePostDTO;
import com.amber.entity.Posts;
import com.baomidou.mybatisplus.extension.service.IService;


public interface PostsService extends IService<Posts> {

    void createPost(CreatePostDTO createPostDTO);
}


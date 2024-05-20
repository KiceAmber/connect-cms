package com.amber.service.impl;

import com.amber.dao.PostsDao;
import com.amber.dao.TagsDao;
import com.amber.dto.posts.CreatePostDTO;
import com.amber.entity.Posts;
import com.amber.service.PostsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("postsService")
public class PostsServiceImpl extends ServiceImpl<PostsDao, Posts> implements PostsService {

    @Resource
    private PostsDao postsDao;

    @Resource
    private TagsDao tagsDao;

    @Override
    public void createPost(CreatePostDTO createPostDTO) {
        Posts posts = new Posts();
        BeanUtils.copyProperties(createPostDTO, posts);
        postsDao.insertOneRecord(posts);
    }
}


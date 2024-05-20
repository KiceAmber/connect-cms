package com.amber.controller;


import com.amber.dto.posts.*;
import com.amber.entity.Posts;
import com.amber.result.PageResult;
import com.amber.result.Result;
import com.amber.service.PostsService;
import com.baomidou.mybatisplus.extension.api.ApiController;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/api/console/posts")
public class PostsController extends ApiController {
    @Resource
    private PostsService postsService;

    // 分页查询所有数据
    @GetMapping("/list")
    public Result<PageResult> selectAll(@RequestBody PostsPageQueryDTO postsPageQueryDTO) {
        PageResult pageResult = postsService.pageQuery(postsPageQueryDTO);
        return Result.success(pageResult);
    }

    // 主键 id 查询单条数据
    @GetMapping("/one")
    public Result<Posts> selectOne(@RequestBody SelectOnePostDTO selectOnePostDTO) {
        return Result.success(postsService.getById(selectOnePostDTO.getId()));
    }

    // 插入一条数据
    @PostMapping
    public Result<String> insert(@RequestBody CreatePostDTO createPostDTO) {
        postsService.createPost(createPostDTO);
        return Result.success();
    }

    // 修改数据
    @PutMapping
    public Result<String> update(@RequestBody UpdatePostDTO updatePostDTO) {
        Posts posts = new Posts();
        BeanUtils.copyProperties(updatePostDTO, posts);
        postsService.updateById(posts);
        return Result.success();
    }

    // TODO: 删除多条数据
    @DeleteMapping
    public Result<String> delete(@RequestBody DeletePostsDTO deletePostsDTO) {
        List<Integer> idList = deletePostsDTO.getIdList();
        postsService.removeByIds(idList);
        return Result.success();
    }
}


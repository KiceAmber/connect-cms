package com.amber.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.amber.entity.PostTags;
import com.amber.service.PostTagsService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * (PostTags)表控制层
 *
 * @author makejava
 * @since 2024-05-12 20:20:53
 */
@RestController
@RequestMapping("postTags")
public class PostTagsController extends ApiController {
    /**
     * 服务对象
     */
    @Resource
    private PostTagsService postTagsService;

    /**
     * 分页查询所有数据
     *
     * @param page     分页对象
     * @param postTags 查询实体
     * @return 所有数据
     */
    @GetMapping
    public R selectAll(Page<PostTags> page, PostTags postTags) {
        return success(this.postTagsService.page(page, new QueryWrapper<>(postTags)));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public R selectOne(@PathVariable Serializable id) {
        return success(this.postTagsService.getById(id));
    }

    /**
     * 新增数据
     *
     * @param postTags 实体对象
     * @return 新增结果
     */
    @PostMapping
    public R insert(@RequestBody PostTags postTags) {
        return success(this.postTagsService.save(postTags));
    }

    /**
     * 修改数据
     *
     * @param postTags 实体对象
     * @return 修改结果
     */
    @PutMapping
    public R update(@RequestBody PostTags postTags) {
        return success(this.postTagsService.updateById(postTags));
    }

    /**
     * 删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    @DeleteMapping
    public R delete(@RequestParam("idList") List<Long> idList) {
        return success(this.postTagsService.removeByIds(idList));
    }
}


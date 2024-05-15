package com.amber.controller;


import com.amber.entity.Posts;
import com.amber.service.PostsService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * (Posts)表控制层
 *
 * @author makejava
 * @since 2024-05-12 20:20:53
 */
@RestController
@RequestMapping("/api/console/posts")
public class PostsController extends ApiController {
    /**
     * 服务对象
     */
    @Resource
    private PostsService postsService;

    /**
     * 分页查询所有数据
     *
     * @param page  分页对象
     * @param posts 查询实体
     * @return 所有数据
     */
    @GetMapping
    public R selectAll(Page<Posts> page, Posts posts) {
        return success(this.postsService.page(page, new QueryWrapper<>(posts)));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public R selectOne(@PathVariable Serializable id) {
        return success(this.postsService.getById(id));
    }

    /**
     * 新增数据
     *
     * @param posts 实体对象
     * @return 新增结果
     */
    @PostMapping
    public R insert(@RequestBody Posts posts) {
        return success(this.postsService.save(posts));
    }

    /**
     * 修改数据
     *
     * @param posts 实体对象
     * @return 修改结果
     */
    @PutMapping
    public R update(@RequestBody Posts posts) {
        return success(this.postsService.updateById(posts));
    }

    /**
     * 删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    @DeleteMapping
    public R delete(@RequestParam("idList") List<Long> idList) {
        return success(this.postsService.removeByIds(idList));
    }
}


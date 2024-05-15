package com.amber.controller;


import com.amber.dto.tags.CreateTagsDTO;
import com.amber.dto.tags.DeleteTagsDTO;
import com.amber.entity.Tags;
import com.amber.result.Result;
import com.amber.service.TagsService;
import com.amber.vo.tags.CreateTagsVO;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * (Tags)表控制层
 *
 * @author makejava
 * @since 2024-05-12 20:20:54
 */
@RestController
@RequestMapping("/api/console/tags")
public class TagsController extends ApiController {

    @Resource
    private TagsService tagsService;

    /**
     * 分页查询所有数据
     *
     * @param page 分页对象
     * @param tags 查询实体
     * @return 所有数据
     */
    @GetMapping
    public Result<?> selectAll(Page<Tags> page, Tags tags) {
        return Result.success(this.tagsService.page(page, new QueryWrapper<>(tags)));
    }

    // 主键 id 查询单条数据
    @GetMapping("/{id}")
    public Result<Tags> selectOne(@PathVariable Serializable id) {
        return Result.success(this.tagsService.getById(id));
    }

    // 插入一条 tags 数据
    @PostMapping
    public Result<CreateTagsVO> insert(@RequestBody CreateTagsDTO createTagsDTO) {
        return Result.success(tagsService.createTag(createTagsDTO));
    }

    /**
     * 修改数据
     *
     * @param tags 实体对象
     * @return 修改结果
     */
    @PutMapping
    public R update(@RequestBody Tags tags) {
        return success(this.tagsService.updateById(tags));
    }

    // 删除多条 tags 数据
    @DeleteMapping
    public Result<?> delete(@RequestBody DeleteTagsDTO deleteTagsDTO) {
        List<Integer> idList = deleteTagsDTO.getIdList();
        return Result.success(this.tagsService.removeByIds(idList));
    }
}


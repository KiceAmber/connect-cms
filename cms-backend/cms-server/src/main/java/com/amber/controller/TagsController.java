package com.amber.controller;


import com.amber.dto.tags.*;
import com.amber.entity.Tags;
import com.amber.result.PageResult;
import com.amber.result.Result;
import com.amber.service.TagsService;
import com.baomidou.mybatisplus.extension.api.ApiController;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
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

    // 分页查询所有数据
    @GetMapping("/list")
    public Result<PageResult> selectAll(@RequestBody TagsPageQueryDTO tagsPageQueryDTO) {
        PageResult pageResult = tagsService.pageQuery(tagsPageQueryDTO);
        return Result.success(pageResult);
    }

    // 主键 id 查询单条数据
    @GetMapping("/one")
    public Result<Tags> selectOne(@RequestBody SelectOneTagDTO selectOneTagDTO) {
        return Result.success(tagsService.getById(selectOneTagDTO.getId()));
    }

    // 插入一条 tags 数据
    @PostMapping
    public Result<String> insert(@RequestBody CreateTagDTO createTagDTO) {
        tagsService.createTag(createTagDTO);
        return Result.success();
    }

    // 修改 Tag 数据
    @PutMapping
    public Result<String> update(@RequestBody UpdateTagDTO updateTagDTO) {
        Tags tags = new Tags();
        BeanUtils.copyProperties(updateTagDTO, tags);
        tagsService.updateById(tags);
        return Result.success();
    }

    // 删除多条 tags 数据
    @DeleteMapping
    public Result<String> delete(@RequestBody DeleteTagsDTO deleteTagsDTO) {
        List<Integer> idList = deleteTagsDTO.getIdList();
        tagsService.removeByIds(idList);
        return Result.success();
    }
}


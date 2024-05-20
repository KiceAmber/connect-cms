package com.amber.controller;


import com.amber.dto.resources.*;
import com.amber.entity.Resources;
import com.amber.result.PageResult;
import com.amber.result.Result;
import com.amber.service.ResourcesService;
import com.baomidou.mybatisplus.extension.api.ApiController;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/api/console/resources")
public class ResourcesController extends ApiController {
    @Resource
    private ResourcesService resourcesService;

    // 分页查询所有数据
    @GetMapping("/list")
    public Result<PageResult> selectAll(@RequestBody ResourcesPageQueryDTO resourcesPageQueryDTO) {
        PageResult pageResult = resourcesService.pageQuery(resourcesPageQueryDTO);
        return Result.success(pageResult);
    }

    // 主键 id 查询单条数据
    @GetMapping("/one")
    public Result<Resources> selectOne(@RequestBody SelectOneResourceDTO selectOneResourceDTO) {
        return Result.success(resourcesService.getById(selectOneResourceDTO.getId()));
    }

    // 插入一条数据
    @PostMapping
    public Result<String> insert(@RequestBody CreateResourceDTO createResourceDTO) {
        resourcesService.createResource(createResourceDTO);
        return Result.success();
    }

    // 修改数据
    @PutMapping
    public Result<String> update(@RequestBody UpdateResourceDTO updateResourceDTO) {
        Resources tags = new Resources();
        BeanUtils.copyProperties(updateResourceDTO, tags);
        resourcesService.updateById(tags);
        return Result.success();
    }

    // 删除多条数据
    @DeleteMapping
    public Result<String> delete(@RequestBody DeleteResourcesDTO deleteResourcesDTO) {
        List<Integer> idList = deleteResourcesDTO.getIdList();
        resourcesService.removeByIds(idList);
        return Result.success();
    }
}


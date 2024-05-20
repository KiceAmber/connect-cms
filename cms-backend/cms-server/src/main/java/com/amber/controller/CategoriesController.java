package com.amber.controller;


import com.amber.dto.categories.*;
import com.amber.entity.Categories;
import com.amber.result.PageResult;
import com.amber.result.Result;
import com.amber.service.CategoriesService;
import com.baomidou.mybatisplus.extension.api.ApiController;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/api/console/categories")
public class CategoriesController extends ApiController {

    @Resource
    private CategoriesService categoriesService;

    // 分页查询所有数据
    @GetMapping("/list")
    public Result<PageResult> selectAll(@RequestBody CategoriesPageQueryDTO categoriesPageQueryDTO) {
        PageResult pageResult = categoriesService.pageQuery(categoriesPageQueryDTO);
        return Result.success(pageResult);
    }

    // 主键 id 查询单条数据
    @GetMapping("/one")
    public Result<Categories> selectOne(@RequestBody SelectOneCategoryDTO selectOneCategoryDTO) {
        return Result.success(categoriesService.getById(selectOneCategoryDTO.getId()));
    }

    // 插入一条数据
    @PostMapping
    public Result<String> insert(@RequestBody CreateCategoryDTO createCategoryDTO) {
        categoriesService.createCategory(createCategoryDTO);
        return Result.success();
    }

    // 修改数据
    @PutMapping
    public Result<String> update(@RequestBody UpdateCategoryDTO updateCategoryDTO) {
        Categories tags = new Categories();
        BeanUtils.copyProperties(updateCategoryDTO, tags);
        categoriesService.updateById(tags);
        return Result.success();
    }

    // 删除多条数据
    @DeleteMapping
    public Result<String> delete(@RequestBody DeleteCategoriesDTO deleteCategoriesDTO) {
        List<Integer> idList = deleteCategoriesDTO.getIdList();
        categoriesService.removeByIds(idList);
        return Result.success();
    }
}


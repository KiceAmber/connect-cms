package com.amber.controller;


import com.amber.dto.categories.CreateCategoryDTO;
import com.amber.dto.categories.DeleteCategoriesDTO;
import com.amber.entity.Categories;
import com.amber.result.Result;
import com.amber.service.CategoriesService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

@RestController
@RequestMapping("/api/console/categories")
public class CategoriesController extends ApiController {

    @Resource
    private CategoriesService categoriesService;

    /**
     * 分页查询所有数据
     *
     * @param page       分页对象
     * @param categories 查询实体
     * @return 所有数据
     */
    @GetMapping
    public R selectAll(Page<Categories> page, Categories categories) {
        return success(this.categoriesService.page(page, new QueryWrapper<>(categories)));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public R selectOne(@PathVariable Serializable id) {
        return success(this.categoriesService.getById(id));
    }

    // 插入一条数据
    @PostMapping
    public Result<String> insert(@RequestBody CreateCategoryDTO createCategoryDTO) {
        categoriesService.createCategory(createCategoryDTO);
        return Result.success();
    }

    /**
     * 修改数据
     *
     * @param categories 实体对象
     * @return 修改结果
     */
    @PutMapping
    public R update(@RequestBody Categories categories) {
        return success(this.categoriesService.updateById(categories));
    }

    // 删除多条数据
    @DeleteMapping
    public Result<String> delete(@RequestBody DeleteCategoriesDTO deleteCategoriesDTO) {
        List<Integer> idList = deleteCategoriesDTO.getIdList();
        categoriesService.removeByIds(idList);
        return Result.success();
    }
}


package com.amber.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.amber.entity.RoleResources;
import com.amber.service.RoleResourcesService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * (RoleResources)表控制层
 *
 * @author makejava
 * @since 2024-05-12 20:20:53
 */
@RestController
@RequestMapping("roleResources")
public class RoleResourcesController extends ApiController {
    /**
     * 服务对象
     */
    @Resource
    private RoleResourcesService roleResourcesService;

    /**
     * 分页查询所有数据
     *
     * @param page          分页对象
     * @param roleResources 查询实体
     * @return 所有数据
     */
    @GetMapping
    public R selectAll(Page<RoleResources> page, RoleResources roleResources) {
        return success(this.roleResourcesService.page(page, new QueryWrapper<>(roleResources)));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public R selectOne(@PathVariable Serializable id) {
        return success(this.roleResourcesService.getById(id));
    }

    /**
     * 新增数据
     *
     * @param roleResources 实体对象
     * @return 新增结果
     */
    @PostMapping
    public R insert(@RequestBody RoleResources roleResources) {
        return success(this.roleResourcesService.save(roleResources));
    }

    /**
     * 修改数据
     *
     * @param roleResources 实体对象
     * @return 修改结果
     */
    @PutMapping
    public R update(@RequestBody RoleResources roleResources) {
        return success(this.roleResourcesService.updateById(roleResources));
    }

    /**
     * 删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    @DeleteMapping
    public R delete(@RequestParam("idList") List<Long> idList) {
        return success(this.roleResourcesService.removeByIds(idList));
    }
}


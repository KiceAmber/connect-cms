package com.amber.controller;


import com.amber.entity.Roles;
import com.amber.service.RolesService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * (Roles)表控制层
 *
 * @author makejava
 * @since 2024-05-12 20:20:54
 */
@RestController
@RequestMapping("/api/console/roles")
public class RolesController extends ApiController {
    /**
     * 服务对象
     */
    @Resource
    private RolesService rolesService;

    /**
     * 分页查询所有数据
     *
     * @param page  分页对象
     * @param roles 查询实体
     * @return 所有数据
     */
    @GetMapping
    public R selectAll(Page<Roles> page, Roles roles) {
        return success(this.rolesService.page(page, new QueryWrapper<>(roles)));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public R selectOne(@PathVariable Serializable id) {
        return success(this.rolesService.getById(id));
    }

    /**
     * 新增数据
     *
     * @param roles 实体对象
     * @return 新增结果
     */
    @PostMapping
    public R insert(@RequestBody Roles roles) {
        return success(this.rolesService.save(roles));
    }

    /**
     * 修改数据
     *
     * @param roles 实体对象
     * @return 修改结果
     */
    @PutMapping
    public R update(@RequestBody Roles roles) {
        return success(this.rolesService.updateById(roles));
    }

    /**
     * 删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    @DeleteMapping
    public R delete(@RequestParam("idList") List<Long> idList) {
        return success(this.rolesService.removeByIds(idList));
    }
}


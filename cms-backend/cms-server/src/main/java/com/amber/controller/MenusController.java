package com.amber.controller;


import com.amber.entity.Menus;
import com.amber.service.MenusService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * (Menus)表控制层
 *
 * @author makejava
 * @since 2024-05-12 20:20:53
 */
@RestController
@RequestMapping("/api/console/menus")
public class MenusController extends ApiController {
    /**
     * 服务对象
     */
    @Resource
    private MenusService menusService;

    /**
     * 分页查询所有数据
     *
     * @param page  分页对象
     * @param menus 查询实体
     * @return 所有数据
     */
    @GetMapping
    public R selectAll(Page<Menus> page, Menus menus) {
        return success(this.menusService.page(page, new QueryWrapper<>(menus)));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public R selectOne(@PathVariable Serializable id) {
        return success(this.menusService.getById(id));
    }

    /**
     * 新增数据
     *
     * @param menus 实体对象
     * @return 新增结果
     */
    @PostMapping
    public R insert(@RequestBody Menus menus) {
        return success(this.menusService.save(menus));
    }

    /**
     * 修改数据
     *
     * @param menus 实体对象
     * @return 修改结果
     */
    @PutMapping
    public R update(@RequestBody Menus menus) {
        return success(this.menusService.updateById(menus));
    }

    /**
     * 删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    @DeleteMapping
    public R delete(@RequestParam("idList") List<Long> idList) {
        return success(this.menusService.removeByIds(idList));
    }
}


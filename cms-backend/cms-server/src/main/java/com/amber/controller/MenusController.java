package com.amber.controller;


import com.amber.dto.menus.*;
import com.amber.entity.Menus;
import com.amber.result.PageResult;
import com.amber.result.Result;
import com.amber.service.MenusService;
import com.baomidou.mybatisplus.extension.api.ApiController;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/api/console/menus")
@Slf4j
public class MenusController extends ApiController {
    @Resource
    private MenusService menusService;

    // 分页查询所有数据
    @GetMapping("/list")
    public Result<PageResult> selectAll(@RequestBody MenusPageQueryDTO menusPageQueryDTO) {
        PageResult pageResult = menusService.pageQuery(menusPageQueryDTO);
        return Result.success(pageResult);
    }

    // 通过主键查询单条数据
    @GetMapping("/one")
    public Result<Menus> selectOne(@RequestBody SelectOneMenuDTO selectOneMenuDTO) {
        return Result.success(this.menusService.getById(selectOneMenuDTO.getId()));
    }

    // 新增菜单
    @PostMapping
    public Result<String> insert(@RequestBody CreateMenuDTO createMenuDTO) {
        this.menusService.createMenu(createMenuDTO);
        return Result.success();
    }

    // 修改数据
    @PutMapping
    public Result<String> update(@RequestBody UpdateMenuDTO updateMenuDTO) {
        Menus menus = new Menus();
        BeanUtils.copyProperties(updateMenuDTO, menus);
        menusService.updateById(menus);
        return Result.success();
    }

    // 删除菜单
    @DeleteMapping
    public Result<String> delete(@RequestBody DeleteMenusDTO deleteMenusDTO) {
        List<Integer> idList = deleteMenusDTO.getIdList();
        menusService.removeByIds(idList);
        return Result.success();
    }
}


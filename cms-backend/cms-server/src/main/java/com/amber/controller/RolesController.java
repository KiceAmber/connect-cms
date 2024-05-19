package com.amber.controller;


import com.amber.dto.roles.*;
import com.amber.entity.Roles;
import com.amber.result.PageResult;
import com.amber.result.Result;
import com.amber.service.RolesService;
import com.baomidou.mybatisplus.extension.api.ApiController;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/api/console/roles")
public class RolesController extends ApiController {

    @Resource
    private RolesService rolesService;

    // 分页查询所有数据
    @GetMapping("/list")
    public Result<PageResult> selectAll(@RequestBody RolesPageQueryDTO rolesPageQueryDTO) {
        PageResult pageResult = rolesService.pageQuery(rolesPageQueryDTO);
        return Result.success(pageResult);
    }

    // 查询单条数据
    @GetMapping("/one")
    public Result<Roles> selectOne(@RequestBody SelectOneRoleDTO selectOneRoleDTO) {
        return Result.success(rolesService.getById(selectOneRoleDTO.getId()));
    }

    // 新增数据
    @PostMapping
    public Result<String> insert(@RequestBody CreateRoleDTO createRoleDTO) {
        this.rolesService.createRole(createRoleDTO);
        return Result.success();
    }

    // 修改数据
    @PutMapping
    public Result<String> update(@RequestBody UpdateRoleDTO updateRoleDTO) {
        Roles roles = new Roles();
        BeanUtils.copyProperties(updateRoleDTO, roles);
        rolesService.updateById(roles);
        return Result.success();
    }

    // 删除数据
    @DeleteMapping
    public Result<String> delete(@RequestBody DeleteRolesDTO deleteRolesDTO) {
        List<Integer> idList = deleteRolesDTO.getIdList();
        rolesService.removeByIds(idList);
        return Result.success();
    }
}


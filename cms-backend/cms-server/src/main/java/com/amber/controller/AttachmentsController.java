package com.amber.controller;


import com.amber.entity.Attachments;
import com.amber.service.AttachmentsService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.List;

/**
 * (Attachments)表控制层
 *
 * @author makejava
 * @since 2024-05-12 20:20:51
 */
@RestController
@RequestMapping("/api/console/attachments")
public class AttachmentsController extends ApiController {
    /**
     * 服务对象
     */
    @Resource
    private AttachmentsService attachmentsService;

    /**
     * 分页查询所有数据
     *
     * @param page        分页对象
     * @param attachments 查询实体
     * @return 所有数据
     */
    @GetMapping
    public R selectAll(Page<Attachments> page, Attachments attachments) {
        return success(this.attachmentsService.page(page, new QueryWrapper<>(attachments)));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public R selectOne(@PathVariable Serializable id) {
        return success(this.attachmentsService.getById(id));
    }

    /**
     * 新增数据
     *
     * @param attachments 实体对象
     * @return 新增结果
     */
    @PostMapping
    public R insert(@RequestBody Attachments attachments) {
        return success(this.attachmentsService.save(attachments));
    }

    /**
     * 修改数据
     *
     * @param attachments 实体对象
     * @return 修改结果
     */
    @PutMapping
    public R update(@RequestBody Attachments attachments) {
        return success(this.attachmentsService.updateById(attachments));
    }

    /**
     * 删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    @DeleteMapping
    public R delete(@RequestParam("idList") List<Long> idList) {
        return success(this.attachmentsService.removeByIds(idList));
    }
}


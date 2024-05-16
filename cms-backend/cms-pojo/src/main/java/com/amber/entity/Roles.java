package com.amber.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;

import java.time.LocalDateTime;

/**
 * (Roles)表实体类
 *
 * @author makejava
 * @since 2024-05-12 20:20:54
 */
public class Roles extends Model<Roles> {
    //角色ID
    @TableId(type = IdType.AUTO)
    private Integer id;
    //角色名称
    private String name;
    //角色描述
    private String description;
    //创建时间
    private LocalDateTime createTime;
}


package com.amber.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

/**
 * (Menus)表实体类
 *
 * @author makejava
 * @since 2024-05-12 20:20:53
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Menus extends Model<Menus> {
    //菜单ID
    @TableId(type = IdType.AUTO)
    private Integer id;
    //父级ID
    private Integer parentId;
    //导航上菜单的排序
    private Integer sort;
    //菜单所指向的URL
    private String url;
    //菜单标题
    private String title;
    //菜单名称
    private String name;
    //菜单图标
    private String icon;
    //创建时间
    private LocalDateTime createTime;
}


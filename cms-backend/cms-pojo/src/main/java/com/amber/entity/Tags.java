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
 * (Tags)表实体类
 *
 * @author makejava
 * @since 2024-05-12 20:20:54
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Tags extends Model<Tags> {
    //标签ID
    @TableId(type = IdType.AUTO)
    private Integer id;
    //标签名称
    private String name;
    //标签描述
    private String description;
    //创建时间
    private LocalDateTime createTime;
}


package com.amber.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
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


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
@AllArgsConstructor
@NoArgsConstructor
public class Posts extends Model<Posts> {
    //内容ID
    @TableId(type = IdType.AUTO)
    private Integer id;
    private Integer type;
    private String title;
    private String cover;
    private String url;
    private String content;
    private String summary;
    private Integer userId;
    private Integer categoryId;
    private Integer commentCount;
    private Integer viewCount;
    private Integer isTop;
    private String slug;
    private Integer status;
    private LocalDateTime createTime;
}


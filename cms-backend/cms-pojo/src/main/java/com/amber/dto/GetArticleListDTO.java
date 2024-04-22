package com.amber.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@ApiModel(description = "管理端分页获取文章列表数据模型")
public class GetArticleListDTO implements Serializable {

    @ApiModelProperty("当前页号")
    private Integer pageNum;

    @ApiModelProperty("当前页大小")
    private Integer pageSize;

    @ApiModelProperty("关键字")
    private String keyWord;
}

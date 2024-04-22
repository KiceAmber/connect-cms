package com.amber.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(description = "管理员登录返回的数据格式")
public class GetArticleListVO implements Serializable {

    @ApiModelProperty("文章总数")
    private Integer total;

    @ApiModelProperty("页号")
    private Integer pageNum;

    @ApiModelProperty("页大小")
    private Integer pageSize;

}

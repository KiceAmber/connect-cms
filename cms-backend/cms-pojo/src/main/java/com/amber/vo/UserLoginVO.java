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
@ApiModel(description = "用户登录返回的数据格式")
public class UserLoginVO implements Serializable {

    @ApiModelProperty("用户ID")
    private Long id;

    @ApiModelProperty("用户名称")
    private String name;

    @ApiModelProperty("JWT令牌")
    private String token;
}

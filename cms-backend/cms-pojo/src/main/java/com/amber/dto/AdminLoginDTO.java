package com.amber.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@ApiModel(description = "管理员登录时传递的数据模型")
public class AdminLoginDTO implements Serializable {

    @ApiModelProperty("管理员账户名称")
    private String name;

    @ApiModelProperty("管理员账户密码")
    private String password;
}

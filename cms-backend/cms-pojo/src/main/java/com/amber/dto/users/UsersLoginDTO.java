package com.amber.dto.users;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
@ApiModel(description = "用户登录时传递的数据模型")
public class UsersLoginDTO implements Serializable {

    @ApiModelProperty("用户账号名称")
    private String passport;

    @ApiModelProperty("用户密码")
    private String password;
}
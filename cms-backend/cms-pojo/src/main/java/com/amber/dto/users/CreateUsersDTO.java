package com.amber.dto.users;

import io.swagger.annotations.ApiModel;
import lombok.Data;

@Data
@ApiModel(description = "创建用户数据模型")
public class CreateUsersDTO {
    private String passport;
    private String nickname;
    private String password;
    private String email;
    private Integer roleId;
}

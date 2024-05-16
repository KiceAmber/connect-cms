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
 * (Users)表实体类
 *
 * @author makejava
 * @since 2024-05-12 20:20:54
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Users extends Model<Users> {
    //用户ID
    @TableId(type = IdType.AUTO)
    private Integer id;
    //用户账号
    private String passport;
    //用户昵称
    private String nickname;
    //用户密码
    private String password;
    //电子邮件
    private String email;
    //用户头像
    private String avatar;
    //角色ID 用户只能赋予一个角色
    private Integer roleId;
    //创建时间
    private LocalDateTime createTime;
}


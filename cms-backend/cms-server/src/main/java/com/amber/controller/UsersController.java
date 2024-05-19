package com.amber.controller;


import com.amber.constant.JwtClaimsConstant;
import com.amber.dto.users.*;
import com.amber.entity.Users;
import com.amber.properties.JwtProperties;
import com.amber.result.PageResult;
import com.amber.result.Result;
import com.amber.service.UsersService;
import com.amber.utils.JwtUtil;
import com.amber.vo.users.UsersLoginVO;
import com.baomidou.mybatisplus.extension.api.ApiController;
import io.swagger.annotations.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.util.DigestUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * (Users)表控制层
 *
 * @author makejava
 * @since 2024-05-12 20:20:54
 */
@Slf4j
@RestController
@RequestMapping("/api/console/users")
@Api(tags = "用户相关接口")
public class UsersController extends ApiController {

    @Resource
    private UsersService usersService;

    @Resource
    private JwtProperties jwtProperties;

    // 用户登录
    @PostMapping("/login")
    public Result<UsersLoginVO> login(@RequestBody UsersLoginDTO userLoginDTO) {
        log.info("用户登录：{}", userLoginDTO);

        Users users = usersService.login(userLoginDTO);

        Map<String, Object> claims = new HashMap<>();
        claims.put(JwtClaimsConstant.USER_ID, users.getId());
        String token = JwtUtil.createJWT(
                jwtProperties.getUserSecretKey(),
                jwtProperties.getUserTtl(),
                claims
        );

        UsersLoginVO userLoginVO = UsersLoginVO.builder()
                .id(users.getId())
                .name(users.getPassport())
                .token(token)
                .build();

        return Result.success(userLoginVO);
    }

    // 分页查询所有数据
    @GetMapping("/list")
    public Result<PageResult> selectAll(@RequestBody UsersPageQueryDTO usersPageQueryDTO) {
        PageResult pageResult = usersService.pageQuery(usersPageQueryDTO);
        return Result.success(pageResult);
    }

    // 主键 id 查询单条数据
    @GetMapping("/one")
    public Result<Users> selectOne(@RequestBody SelectOneUserDTO selectOneUserDTO) {
        return Result.success(usersService.getById(selectOneUserDTO.getId()));
    }

    // 创建新的用户
    @PostMapping
    public Result<String> insert(@RequestBody CreateUserDTO createUserDTO) {
        usersService.createUser(createUserDTO);
        return Result.success();
    }

    // 修改用户基本信息数据
    @PutMapping("/info")
    public Result<String> updateUserInfo(@RequestBody UpdateUserInfoDTO updateUserInfoDTO) {
        Users users = new Users();
        BeanUtils.copyProperties(updateUserInfoDTO, users);
        usersService.updateById(users);
        return Result.success();
    }

    // 修改用户密码
    @PutMapping("/password")
    public Result<String> updateUserPassword(@RequestBody UpdateUserPasswordDTO updateUserPasswordDTO) {
        Users users = new Users();
        BeanUtils.copyProperties(updateUserPasswordDTO, users);
        users.setPassword(DigestUtils.md5DigestAsHex(updateUserPasswordDTO.getPassword().getBytes()));
        usersService.updateById(users);
        return Result.success();
    }

    // 删除多条 tags 数据
    @DeleteMapping
    public Result<String> delete(@RequestBody DeleteUsersDTO deleteUsersDTO) {
        List<Integer> idList = deleteUsersDTO.getIdList();
        usersService.removeByIds(idList);
        return Result.success();
    }
}


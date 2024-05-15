package com.amber.controller;


import com.amber.constant.JwtClaimsConstant;
import com.amber.dto.users.CreateUsersDTO;
import com.amber.dto.users.UsersLoginDTO;
import com.amber.entity.Users;
import com.amber.properties.JwtProperties;
import com.amber.result.Result;
import com.amber.service.UsersService;
import com.amber.utils.JwtUtil;
import com.amber.vo.users.UsersLoginVO;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.api.R;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.Serializable;
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

    @Autowired
    private JwtProperties jwtProperties;

    @PostMapping("/login")
    @ApiOperation("用户登录")
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

    /**
     * 分页查询所有数据
     *
     * @param page  分页对象
     * @param users 查询实体
     * @return 所有数据
     */
    @GetMapping
    public R selectAll(Page<Users> page, Users users) {
        return success(this.usersService.page(page, new QueryWrapper<>(users)));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public R selectOne(@PathVariable Serializable id) {
        return success(this.usersService.getById(id));
    }

    // 创建新的用户
    @PostMapping
    public Result<?> insert(@RequestBody CreateUsersDTO createUsersDTO) {
        return Result.success(usersService.createUser(createUsersDTO));
    }

    /**
     * 修改数据
     *
     * @param users 实体对象
     * @return 修改结果
     */
    @PutMapping
    public R update(@RequestBody Users users) {
        return success(this.usersService.updateById(users));
    }

    /**
     * 删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    @DeleteMapping
    public R delete(@RequestParam("idList") List<Long> idList) {
        return success(this.usersService.removeByIds(idList));
    }
}


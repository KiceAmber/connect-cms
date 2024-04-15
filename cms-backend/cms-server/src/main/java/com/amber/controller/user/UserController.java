package com.amber.controller.user;

import com.amber.constant.JwtClaimsConstant;
import com.amber.dto.UserLoginDTO;
import com.amber.entity.User;
import com.amber.properties.JwtProperties;
import com.amber.result.Result;
import com.amber.service.UserService;
import com.amber.utils.JwtUtil;
import com.amber.vo.UserLoginVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import me.zhyd.oauth.config.AuthConfig;
import me.zhyd.oauth.request.AuthGiteeRequest;
import me.zhyd.oauth.request.AuthRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/user/user")
@Api(tags = "用户相关接口")
public class UserController {

    @Autowired
    private UserService userService;
    @Autowired
    private JwtProperties jwtProperties;

    /**
     * 用户注册
     *
     * @param name
     * @return
     */
    @PostMapping("/register")
    @ApiOperation("用户注册")
    public Result<?> register(@RequestBody String name) {
        // TODO: 用户注册
        return null;
    }

    /**
     * 用户登录
     *
     * @param userLoginDTO
     * @return
     */
    @PostMapping("/login")
    @ApiOperation("用户登录")
    public Result<UserLoginVO> login(@RequestBody UserLoginDTO userLoginDTO) {
        log.info("用户登录：{}", userLoginDTO);

        User user = userService.login(userLoginDTO);

        // 登录成功后，生成 jwt 令牌
        Map<String, Object> claims = new HashMap<>();
        claims.put(JwtClaimsConstant.USER_ID, user.getId());
        String token = JwtUtil.createJWT(
                jwtProperties.getUserSecretKey(),
                jwtProperties.getUserTtl(),
                claims
        );

        UserLoginVO userLoginVO = UserLoginVO.builder()
                .id(user.getId())
                .name(user.getName())
                .token(token)
                .build();

        return Result.success(userLoginVO);
    }

    /**
     * 第三方平台授权登录
     *
     * @param name
     * @return
     */
    @PostMapping("/thirdLogin")
    @ApiOperation("第三方平台授权登录")
    public Result<?> thirdPlatformLogin(@RequestBody String name) {

        // 创建授权request
        AuthRequest authRequest = getAuthRequest();
        // 生成授权页面
        String authorizeUrl = authRequest.authorize("state");
        // 授权登录后会返回code（auth_code（仅限支付宝））、state，1.8.0版本后，可以用AuthCallback类作为回调接口的参数
        // 注：JustAuth默认保存state的时效为3分钟，3分钟内未使用则会自动清除过期的state
        authRequest.login(callback);
        return null;
    }

    private AuthRequest getAuthRequest() {
        return new AuthGiteeRequest(AuthConfig.builder()
                .clientId("ClientId")
                .clientSecret("client Server")
                .redirectUri("回调地址")
                .build());
    }
}

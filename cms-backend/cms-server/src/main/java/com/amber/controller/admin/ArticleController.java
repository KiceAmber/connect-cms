package com.amber.controller.admin;

import com.amber.dto.GetArticleListDTO;
import com.amber.result.Result;
import com.amber.vo.GetArticleListVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/admin/article")
@Api(tags = "文章相关接口")
public class ArticleController {

    @PostMapping("/getArticleList")
    @ApiOperation("分页获取文章列表，可通过关键字过滤数据")
    public Result<GetArticleListVO> login(@RequestBody GetArticleListDTO getArticleListDTO) {

        return null;
    }
}

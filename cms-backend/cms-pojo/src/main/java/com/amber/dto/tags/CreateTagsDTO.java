package com.amber.dto.tags;

import io.swagger.annotations.ApiModel;
import lombok.Data;

@Data
@ApiModel(description = "创建标签数据模型")
public class CreateTagsDTO {
    private String name;
    private String description;
}

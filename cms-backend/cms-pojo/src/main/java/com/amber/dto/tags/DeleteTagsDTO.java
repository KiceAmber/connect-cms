package com.amber.dto.tags;


import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import lombok.Data;

import java.util.List;

@Data
@ApiModel(description = "删除标签数据模型")
public class DeleteTagsDTO {
    @JsonProperty("idList")
    private List<Integer> idList;
}

package com.amber.dto.posts;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DeletePostsDTO implements Serializable {
    @JsonProperty("idList")
    private List<Integer> idList;
}

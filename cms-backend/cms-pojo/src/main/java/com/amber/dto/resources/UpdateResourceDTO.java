package com.amber.dto.resources;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class UpdateResourceDTO implements Serializable {
    private Integer id;
    private String name;
    private String description;
    private String path;
}

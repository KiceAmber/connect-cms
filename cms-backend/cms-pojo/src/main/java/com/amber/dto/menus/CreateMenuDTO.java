package com.amber.dto.menus;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateMenuDTO implements Serializable {
    private Integer parentId;
    private String url;
    private String title;
    private String name;
    private String icon;
}

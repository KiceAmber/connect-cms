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
public class UpdateMenuDTO implements Serializable {
    private Integer id;
    private Integer parentId;
    private String url;
    private String title;
    private String name;
    private String icon;
}

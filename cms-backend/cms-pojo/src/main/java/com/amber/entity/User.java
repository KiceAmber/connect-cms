package com.amber.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private static final long serialVersionUID = 1L;

    private Long id;

    private String name;

    private String password;

    private String email;

    private String signature;

    private String avatar;

    private LocalDateTime createTime;
}
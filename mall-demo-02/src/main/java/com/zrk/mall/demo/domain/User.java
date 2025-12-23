package com.zrk.mall.demo.domain;

import lombok.Data;

/**
 * 简单用户封装
 * Created by zrk on 2025/12/23
 */
@Data
public class User {
    private Long id;
    private String username;
    private String password;

    public User(Long id, String username, String password) {
        this.id = id;
        this.username = username;
        this.password = password;
    }
}

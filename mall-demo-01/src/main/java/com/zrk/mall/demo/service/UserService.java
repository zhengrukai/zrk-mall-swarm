package com.zrk.mall.demo.service;

import com.zrk.mall.demo.domain.User;

import java.util.List;

/**
 * 用户管理 Service
 * Created by zrk on 2025/12/23
 */
public interface UserService {

    void create(User user);

    User getUser(Long id);

    void update(User user);

    void delete(Long id);

    User getByUsername(String username);

    List<User> getUserByIds(List<Long> ids);
}

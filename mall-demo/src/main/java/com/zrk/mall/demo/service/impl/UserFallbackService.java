package com.zrk.mall.demo.service.impl;

import com.zrk.mall.common.api.CommonResult;
import com.zrk.mall.demo.domain.User;
import com.zrk.mall.demo.service.UserService;
import org.springframework.stereotype.Component;

/**
 * UserService中的服务降级处理逻辑
 * Created by zrk on 2025/12/28
 */
@Component
public class UserFallbackService implements UserService {
    @Override
    public CommonResult<User> create(User user) {
        User defaultUser = new User(-1L, "defaultUser", "123456");
        return CommonResult.success(defaultUser, "服务降级返回");
    }

    @Override
    public CommonResult<User> getUser(Long id) {
        User defaultUser = new User(-1L, "defaultUser", "123456");
        return CommonResult.success(defaultUser, "服务降级返回");
    }

    @Override
    public CommonResult<User> getByUsername(String username) {
        User defaultUser = new User(-1L, "defaultUser", "123456");
        return CommonResult.success(defaultUser, "服务降级返回");
    }

    @Override
    public CommonResult update(User user) {
        return CommonResult.failed("调用失败，服务被降级");
    }

    @Override
    public CommonResult delete(Long id) {
        return CommonResult.failed("调用失败，服务被降级");
    }
}

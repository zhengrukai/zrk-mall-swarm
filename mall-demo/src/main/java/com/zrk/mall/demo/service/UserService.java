package com.zrk.mall.demo.service;

import com.zrk.mall.common.api.CommonResult;
import com.zrk.mall.demo.domain.User;
import com.zrk.mall.demo.service.impl.UserFallbackService;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

/**
 * OpenFeign远程调用user-service的业务类
 * Created by zrk on 2025/12/28
 */
@FeignClient(value = "mall-demo-01", contextId = "userService", fallback = UserFallbackService.class)
public interface UserService {
    @PostMapping("/user/create")
    CommonResult create(@RequestBody User user);

    @GetMapping("/user/{id}")
    CommonResult<User> getUser(@PathVariable("id") Long id);

    @GetMapping("/user/getByUsername")
    CommonResult<User> getByUsername(@RequestParam("username") String username);

    @PostMapping("/user/update")
    CommonResult update(@RequestBody User user);

    @PostMapping("/user/delete/{id}")
    CommonResult delete(@PathVariable("id") Long id);
}

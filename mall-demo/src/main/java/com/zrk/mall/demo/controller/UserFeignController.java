package com.zrk.mall.demo.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.zrk.mall.common.api.CommonResult;
import com.zrk.mall.demo.domain.User;
import com.zrk.mall.demo.handler.CustomBlockHandler;
import com.zrk.mall.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 通过OpenFeign远程调用user-service的Controller
 * Created by zrk on 2025/12/28
 */
@RestController
@RequestMapping("/userFeign")
public class UserFeignController {

    @Autowired
    private UserService userService;

    @GetMapping("/{id}")
    public CommonResult getUser(@PathVariable Long id) {
        return userService.getUser(id);
    }

    @GetMapping("/getByUsername")
    @SentinelResource(value = "getByUsername", blockHandler = "handleException", blockHandlerClass = CustomBlockHandler.class)
    public CommonResult getByUsername(@RequestParam String username) {
        return userService.getByUsername(username);
    }

    @PostMapping("/create")
    public CommonResult create(@RequestBody User user) {
        return userService.create(user);
    }

    @PostMapping("/update")
    public CommonResult update(@RequestBody User user) {
        return userService.update(user);
    }

    @PostMapping("/delete/{id}")
    public CommonResult delete(@PathVariable Long id) {
        return userService.delete(id);
    }
}

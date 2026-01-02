package com.zrk.mall.auth.controller;

import com.zrk.mall.auth.domain.UmsAdminLoginParam;
import com.zrk.mall.auth.service.UmsAdminService;
import com.zrk.mall.common.api.CommonResult;
import com.zrk.mall.common.constant.AuthConstant;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 统一认证授权接口
 * Created by zrk on 2026/1/2
 */
@Controller
@Tag(name = "AuthController", description = "统一认证授权接口")
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private UmsAdminService adminService;

    @Operation(summary = "登录以后返回token")
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public CommonResult login(@RequestParam String clientId,
                              @RequestParam String username,
                              @RequestParam String password) {
        if (AuthConstant.ADMIN_CLIENT_ID.equals(clientId)) {
            UmsAdminLoginParam loginParam = new UmsAdminLoginParam();
            loginParam.setUsername(username);
            loginParam.setPassword(password);
            return adminService.login(loginParam);
        } else {
            return CommonResult.failed("clientId不正确");
        }
    }
}

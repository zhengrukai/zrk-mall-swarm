package com.zrk.mall.controller;

import com.zrk.mall.common.api.CommonResult;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 后台用户管理
 * Created by zrk on 2026/1/30
 */
@Controller
@Tag(name = "UmsAdminController", description = "后台用户管理")
@RequestMapping("/admin")
public class UmsAdminController {
    @Value("${sa-token.token-prefix}")
    private String tokenHead;

    @Operation(summary = "登录查询账号列表")
    public CommonResult login() {

    }
}

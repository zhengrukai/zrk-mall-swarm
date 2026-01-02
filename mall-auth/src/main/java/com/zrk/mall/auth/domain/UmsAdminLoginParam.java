package com.zrk.mall.auth.domain;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 用户登录参数
 * Created by zrk on 2026/1/2
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class UmsAdminLoginParam {
    @NotEmpty
    @Schema(title = "用户名")
    private String username;

    @NotEmpty
    @Schema(title = "密码")
    private String password;
}

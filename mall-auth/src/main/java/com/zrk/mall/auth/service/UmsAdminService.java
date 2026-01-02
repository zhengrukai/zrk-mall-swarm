package com.zrk.mall.auth.service;

import com.zrk.mall.auth.domain.UmsAdminLoginParam;
import com.zrk.mall.common.api.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * 后台用户服务远程调用Service
 * Created by zrk on 2026/1/2
 */
@FeignClient("mall-admin")
public interface UmsAdminService {

    @PostMapping("/admin/login")
    CommonResult login(@RequestBody UmsAdminLoginParam umsAdminLoginParam);
}

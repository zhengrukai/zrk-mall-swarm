package com.zrk.mall.demo.service;

import com.zrk.mall.common.api.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 远程调用storage-service的接口
 * Created by zrk on 2025/12/29
 */
@FeignClient(value = "mall-demo-02")
public interface StorageService {
    /**
     * 扣减库存
     */
    @GetMapping(value = "/storage/decrease")
    CommonResult decrease(@RequestParam("productId") Long productId, @RequestParam("count") Integer count);
}

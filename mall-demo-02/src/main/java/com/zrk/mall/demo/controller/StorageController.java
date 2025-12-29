package com.zrk.mall.demo.controller;

import com.zrk.mall.common.api.CommonResult;
import com.zrk.mall.demo.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 库存管理Controller
 * Created by zrk on 2025/12/29
 */
@RestController
@RequestMapping("/storage")
public class StorageController {

    @Autowired
    private StorageService storageService;

    /**
     * 扣减库存
     */
    @RequestMapping("/decrease")
    public CommonResult decrease(Long productId, Integer count) {
        storageService.decrease(productId, count);
        return CommonResult.success("扣减库存成功！");
    }
}

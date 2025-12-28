package com.zrk.mall.demo.handler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.zrk.mall.common.api.CommonResult;

/**
 * 自定义限流逻辑处理类
 * Created by zrk on 2025/12/28
 */
public class CustomBlockHandler {
    public static CommonResult handleException(String resource, BlockException exception) {
        return CommonResult.success("操作过于频繁，请稍后再试！");
    }
}

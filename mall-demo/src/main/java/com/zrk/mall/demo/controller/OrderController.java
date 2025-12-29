package com.zrk.mall.demo.controller;

import com.zrk.mall.common.api.CommonResult;
import com.zrk.mall.demo.domain.Order;
import com.zrk.mall.demo.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 订单管理Controller
 * Created by zrk on 2025/12/29
 */
@RestController
@RequestMapping(value = "/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    /**
     * 创建订单
     */
    @GetMapping("/create")
    public CommonResult create(Order order) {
        orderService.create(order);
        return CommonResult.success("订单创建成功！");
    }
}

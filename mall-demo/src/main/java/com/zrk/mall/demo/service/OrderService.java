package com.zrk.mall.demo.service;

import com.zrk.mall.demo.domain.Order;

/**
 * 订单管理Service
 * Created by zrk on 2025/12/29
 */
public interface OrderService {
    /**
     * 创建订单
     */
    void create(Order order);
}

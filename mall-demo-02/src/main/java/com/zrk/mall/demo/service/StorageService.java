package com.zrk.mall.demo.service;

/**
 * 库存管理Service
 * Created by zrk on 2025/12/29
 */
public interface StorageService {
    /**
     * 扣减库存
     */
    void decrease(Long productId, Integer count);
}

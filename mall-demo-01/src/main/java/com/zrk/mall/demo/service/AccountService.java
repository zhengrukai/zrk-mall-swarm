package com.zrk.mall.demo.service;

import java.math.BigDecimal;

/**
 * 账户管理Service
 * Created by zrk on 2025/12/29
 */
public interface AccountService {
    /**
     * 扣减账户余额
     * @param userId 用户id
     * @param money 金额
     */
    void decrease(Long userId, BigDecimal money);
}

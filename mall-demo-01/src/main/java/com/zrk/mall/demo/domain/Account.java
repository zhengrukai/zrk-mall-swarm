package com.zrk.mall.demo.domain;

import lombok.Data;

import java.math.BigDecimal;

/**
 * 账户管理实体类
 * Created by zrk on 2025/12/29
 */
@Data
public class Account {

    private Long id;

    /**
     * 用户id
     */
    private Long userId;

    /**
     * 总额度
     */
    private BigDecimal total;

    /**
     * 已用额度
     */
    private BigDecimal used;

    /**
     * 剩余额度
     */
    private BigDecimal residue;
}

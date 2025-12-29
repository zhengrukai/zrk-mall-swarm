package com.zrk.mall.demo.domain;

import lombok.Data;

import java.math.BigDecimal;

/**
 * 订单实体类
 * Created by zrk on 2025/12/29
 */
@Data
public class Order {

    private Long id;

    private Long userId;

    private Long productId;

    private Integer count;

    private BigDecimal money;

    /**
     * 订单状态：0：创建中；1：已完结
     */
    private Integer status;
}

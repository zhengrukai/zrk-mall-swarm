package com.zrk.mall.demo.domain;

import lombok.Data;

/**
 * 库存管理实体类
 * Created by zrk on 2025/12/29
 */
@Data
public class Storage {

    private Long id;

    /**
     * 产品id
     */
    private Long productId;

    /**
     * 总库存
     */
    private Integer total;

    /**
     * 已用库存
     */
    private Integer used;

    /**
     * 剩余库存
     */
    private Integer residue;
}

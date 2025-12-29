package com.zrk.mall.demo.dao;

import com.zrk.mall.demo.domain.Order;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * 订单管理Dao
 * Created by zrk on 2025/12/29
 */
@Repository
public interface OrderDao {
    /**
     * 创建订单
     */
    void create(Order order);

    /**
     * 修改订单金额
     */
    void update(@Param("userId") Long userId, @Param("status") Integer status);
}

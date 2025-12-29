package com.zrk.mall.demo.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * MyBatis相关配置
 * Created by zrk on 2025/12/29
 */
@Configuration
@EnableTransactionManagement
@MapperScan({"com.zrk.mall.mapper", "com.zrk.mall.demo.dao"})
public class MyBatisConfig {
}

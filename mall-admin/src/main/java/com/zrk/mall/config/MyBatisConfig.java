package com.zrk.mall.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * MyBatis相关配置
 * Created by zrk on 2026/1/2
 */
@Configuration
@EnableTransactionManagement
@MapperScan({"com.zrk.mall.mapper", "com.zrk.mall.dao"})
public class MyBatisConfig {
}

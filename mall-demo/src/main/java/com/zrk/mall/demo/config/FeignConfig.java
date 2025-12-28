package com.zrk.mall.demo.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * OpenFeign配置类
 * Created by zrk on 2025/12/28
 */
@Configuration
public class FeignConfig {
    @Bean
    Logger.Level feightLoggerLevel() {
        return Logger.Level.FULL;
    }
}

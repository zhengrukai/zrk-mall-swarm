package com.zrk.mall.demo.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by zrk on 2026/1/30
 * Feign调用mall-admin接口示例
 */
@Tag(name = "FeignAdminController", description = "Feign调用mall-admin接口示例")
@RestController
@RequestMapping("/feign/admin")
public class FeignAdminController {

}

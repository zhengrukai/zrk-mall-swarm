package com.zrk.mall.demo.controller;

import cn.hutool.core.thread.ThreadUtil;
import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.zrk.mall.common.api.CommonResult;
import com.zrk.mall.demo.domain.User;
import com.zrk.mall.demo.handler.CustomBlockHandler;
import com.zrk.mall.demo.service.UserService;
import io.opentracing.Span;
import io.opentracing.Tracer;
import org.apache.skywalking.apm.toolkit.opentracing.SkywalkingTracer;
import org.apache.skywalking.apm.toolkit.trace.ActiveSpan;
import org.apache.skywalking.apm.toolkit.trace.Tag;
import org.apache.skywalking.apm.toolkit.trace.Trace;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 通过OpenFeign远程调用user-service的Controller
 * Created by zrk on 2025/12/28
 */
@RestController
@RequestMapping("/userFeign")
public class UserFeignController {

    @Autowired
    private UserService userService;

    @Trace
    @Tag(key = "userId", value = "arg[0]")//arg[0]为固定写法
    @Tag(key = "result.id", value = "returnedObj.data.id")//returnedObj为固定写法
    @Tag(key = "result.username", value = "returnedObj.data.username")
    @GetMapping("/{id}")
    public CommonResult getUser(@PathVariable Long id) {
        ActiveSpan.debug("activeSpan debug message...");
        ActiveSpan.info("activeSpan info message...");
        ActiveSpan.error("activeSpan error message...");
        //模拟一个耗时操作
        ThreadUtil.safeSleep(1000);
        //只监控startManual和finish之间的代码片段
        Tracer tracer = new SkywalkingTracer();
        Tracer.SpanBuilder spanBuilder = tracer.buildSpan("/userFeign-span/getUser");
        Span span = spanBuilder.withTag("tag", "getUser").startManual();
        CommonResult<User> result = userService.getUser(id);
        span.finish();
        return result;
    }

    @GetMapping("/getByUsername")
    @SentinelResource(value = "getByUsername", blockHandler = "handleException", blockHandlerClass = CustomBlockHandler.class)
    public CommonResult getByUsername(@RequestParam String username) {
        return userService.getByUsername(username);
    }

    @PostMapping("/create")
    public CommonResult create(@RequestBody User user) {
        return userService.create(user);
    }

    @PostMapping("/update")
    public CommonResult update(@RequestBody User user) {
        return userService.update(user);
    }

    @PostMapping("/delete/{id}")
    public CommonResult delete(@PathVariable Long id) {
        return userService.delete(id);
    }
}

package com.zrk.mall.common.exception;

import com.zrk.mall.common.api.IErrorCode;

/**
 * 断言处理类，用于抛出各种API异常
 * Created by zrk on 2025/12/23.
 */
public class Asserts {
    public static void fail(String message) {
        throw new ApiException(message);
    }

    public static void fail(IErrorCode errorCode) {
        throw new ApiException(errorCode);
    }
}

package com.weng.demo.res;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * 正確回傳
 */
@Getter
@Setter
@AllArgsConstructor
public class Response {
    private int code;
    private String message;

    // 可自訂義回傳function
}

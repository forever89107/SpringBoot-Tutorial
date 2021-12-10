package com.weng.demo.res;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * 錯誤回傳
 */
@Getter
@Setter
@AllArgsConstructor
public class ResponseException extends RuntimeException{
    private int errorCode;
    private String message;

    // 可自訂義回傳的錯誤function
}

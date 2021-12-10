package com.weng.demo.res;

import com.weng.demo.controller.dto.PlayerDto;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

/**
 * 正確回傳
 */
@Getter
@Setter
@AllArgsConstructor
public class Response {
    //檢核碼
    private int code;
    //回傳訊息
    private String message;
    //回傳內容
    private List<PlayerDto> result = new ArrayList<>();

    // 一般回傳
    public Response(int code, String message) {
        this.code = code;
        this.message = message;
    }

    // 可自訂義回傳function
}

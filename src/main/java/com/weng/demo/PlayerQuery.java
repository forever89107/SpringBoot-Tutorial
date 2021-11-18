package com.weng.demo;

import lombok.Getter;
import lombok.Setter;

/**
 * 玩家搜尋參數
 */
@Getter
@Setter
public class PlayerQuery {
    // 指定玩家ID
    public String id;
    // 指定玩家暱稱
    private String playerName;
    // id 排序
    private String sortId;
    // 等級排序
    private String sortLevel;
}

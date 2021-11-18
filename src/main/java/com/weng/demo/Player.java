package com.weng.demo;

import lombok.Getter;
import lombok.Setter;

/**
 * 玩家屬性
 */

@Getter
@Setter
public class Player {
    // 玩家ID
    public String id;
    // 玩家暱稱
    private String playerName;
    // 玩家職業
    private String job;
    // 玩家等級
    private int level = 1;
}

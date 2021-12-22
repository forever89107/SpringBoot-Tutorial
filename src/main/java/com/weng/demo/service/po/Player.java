package com.weng.demo.service.po;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 玩家-實體類(PO)
 */

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
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

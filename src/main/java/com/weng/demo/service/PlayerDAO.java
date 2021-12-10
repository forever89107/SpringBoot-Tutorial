package com.weng.demo.service;

import com.weng.demo.common.CommonQuery;
import com.weng.demo.controller.dto.PlayerDto;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.*;
import java.util.stream.Collectors;

/**
 * PlayerDAO
 */

@Repository
public class PlayerDAO {
    // 模擬玩家的資料庫列表
    private final List<PlayerDto> playerDtoDB = new ArrayList<>();

    // 初始化 玩家資料庫內容
    @PostConstruct
    protected void initDB() {
        playerDtoDB.add(new PlayerDto("A0001", "鎚鎚大師", "初心者", 10));
        playerDtoDB.add(new PlayerDto("A0002", "微米刺客", "刺客", 52));
        playerDtoDB.add(new PlayerDto("A0003", "甜蜜貓咪咪", "祭司", 27));
        playerDtoDB.add(new PlayerDto("A0004", "軟綿綿啾啾", "聖騎士", 35));
        playerDtoDB.add(new PlayerDto("A0005", "一品帶刀Lovely", "狂戰士", 73));
    }

    /**
     * 根據ID 查詢玩家
     */
    public Optional<PlayerDto> select(String id) {
        Optional<PlayerDto> result = playerDtoDB.stream().
                filter(p -> p.getId().equals(id))
                .findFirst();
        return result;
    }

    /**
     * 根據需求，查詢玩家
     */
    public List<PlayerDto> select(CommonQuery query) {
        String sortBy = query.getSortBy();
        String sortRule = query.getSortRule();
        Comparator<PlayerDto> comparator = playerComparator(sortBy, sortRule);

        List<PlayerDto> playerDtos = playerDtoDB.stream()
                .sorted(comparator)
                .collect(Collectors.toList());

        return playerDtos;
    }

    /**
     * 新增玩家
     */
    public PlayerDto insert(PlayerDto dto) {
        playerDtoDB.add(dto);
        return dto;
    }

    /**
     * 更新玩家資訊
     */
    public PlayerDto update(String id, PlayerDto req) {
        Optional<PlayerDto> productOp = select(id);
        productOp.ifPresent(p -> {
            PlayerDto playerDto = productOp.get();
            playerDto.setPlayerName(req.getPlayerName());
            playerDto.setLevel(req.getLevel());
            playerDto.setJob(req.getJob());
        });
        return req;
    }

    /**
     * 刪除
     */
    public Boolean delete(String id) {
        return playerDtoDB.removeIf(p -> p.getId().equals(id));
    }

    /**
     * 比較器方法
     */
    private Comparator<PlayerDto> playerComparator(String sortBy, String sortRule) {
        Comparator<PlayerDto> comparator = (o1, o2) -> (0);
        // 如條件不齊全，直接返回
        if (Objects.isNull(sortBy) || Objects.isNull(sortRule)) return comparator;

        if (sortBy.equalsIgnoreCase("id")) {
            comparator = Comparator.comparing(PlayerDto::getId);
        } else if (sortBy.equalsIgnoreCase("level")) {
            comparator = Comparator.comparing(PlayerDto::getLevel);
        }
        return sortRule.equalsIgnoreCase("asc") ? comparator : comparator.reversed();
    }
}

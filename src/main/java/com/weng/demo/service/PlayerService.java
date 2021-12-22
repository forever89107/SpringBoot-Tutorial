package com.weng.demo.service;

import com.weng.demo.common.CommonQuery;
import com.weng.demo.controller.dto.PlayerDto;
import com.weng.demo.dao.PlayerMapper;
import com.weng.demo.res.ResponseException;
import com.weng.demo.service.po.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * PlayerService 層
 */
@Service
public class PlayerService {

    @Autowired
    private PlayerDAO playerDAO;

    @Autowired
    private PlayerMapper playerMapper;

    /**
     * 查詢列表
     */
    public List<PlayerDto> getAllPlayer(CommonQuery query) {
        return playerDAO.select(query);
    }

    /**
     * 查詢
     */
    public PlayerDto getPlayerInfo(String id) {
        Player player = playerMapper.findById(id);
        return poToDto(player);
//        return playerDAO.select(id).orElseThrow(() ->
//                new ResponseException(HttpStatus.NOT_FOUND.value(), "查無此人"));
    }

    /**
     * 新增
     */
    public PlayerDto newPlayer(PlayerDto req) {
        // 檢查此Id是否已存在
        boolean isExistId = playerDAO.select(req.getId()).isPresent();
        if (isExistId) {
            throw new ResponseException(HttpStatus.UNPROCESSABLE_ENTITY.value(), "Id已存在");
        }
        // 新增新玩家
        PlayerDto playerDto = new PlayerDto();
        playerDto.setId(req.getId());
        playerDto.setPlayerName(req.getPlayerName());
        playerDto.setJob(req.getJob());
        playerDto.setLevel(req.getLevel());

        return playerDAO.insert(playerDto);
    }

    /**
     * 編輯
     */
    public PlayerDto editPlayer(String id, PlayerDto request) {
        PlayerDto player = getPlayerInfo(id);
        return playerDAO.update(player.getId(), request);
    }

    /**
     * 刪除
     */
    public Boolean deletePlayer(String id) {
        PlayerDto player = getPlayerInfo(id);
        return playerDAO.delete(player.getId());
    }

    /**
     * PO 轉 DTO
     */
    private PlayerDto poToDto(Player player){
        PlayerDto dto = new PlayerDto();
        dto.setId(player.getId());
        dto.setJob(player.getJob());
        dto.setLevel(player.getLevel());
        dto.setPlayerName(player.getPlayerName());
        return dto;
    }
}

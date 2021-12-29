package com.weng.demo.service;

import com.weng.demo.common.CommonQuery;
import com.weng.demo.controller.dto.PlayerDto;
import com.weng.demo.dao.PlayerMapper;
import com.weng.demo.dao.generate.po.PlayerDom;
import com.weng.demo.dao.generate.po.PlayerDomExample;
import com.weng.demo.res.ResponseException;
import com.weng.demo.service.po.Player;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


/**
 * PlayerService 層
 */
@Service
public class PlayerService {

    //    @Autowired
    //    private PlayerDAO playerDAO;

    @Autowired
    private PlayerMapper playerMapper;

    /**
     * 查詢列表
     */
    public List<PlayerDto> getAllPlayer(CommonQuery query) {
        PlayerDomExample example = new PlayerDomExample();
        example.setOrderByClause(query.getSortBy() + " " + query.getSortRule()); //level desc
        List<PlayerDom> doms = playerMapper.selectByExample(example);

        // 轉為 DTO
        List<PlayerDto> result = doms.stream().map(dom -> poToDto(dom)).collect(Collectors.toList());
        return result;
    }

    /**
     * 查詢
     */
    public PlayerDto getPlayerInfo(String id) {
        PlayerDom player = playerMapper.selectByPrimaryKey(id);
        if (null == player)
            throw new ResponseException(HttpStatus.NOT_FOUND.value(), "查無此人");

        return poToDto(player);
    }

    /**
     * 新增
     */
    public PlayerDto newPlayer(PlayerDto req) {
        // 檢查此Id是否已存在
        PlayerDom dom = playerMapper.selectByPrimaryKey(req.getId());
        if (null != dom)
            throw new ResponseException(HttpStatus.UNPROCESSABLE_ENTITY.value(), "Id已存在");

        // 新增玩家成功
        PlayerDom newDom = new PlayerDom();
        newDom.setId(req.getId());
        newDom.setJob(req.getJob());
        newDom.setPlayerName(req.getPlayerName());
        newDom.setLevel(req.getLevel());

        if (playerMapper.insert(newDom) > 0)
            return poToDto(newDom);
        else
            throw new ResponseException(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Internal Server Error");
    }

    /**
     * 編輯
     */
    public PlayerDto editPlayer(PlayerDto req) {
        // 檢查此Id是否有存在
        PlayerDom dom = playerMapper.selectByPrimaryKey(req.getId());
        if (null == dom)
            throw new ResponseException(HttpStatus.NOT_FOUND.value(), "查無此人");
        // 更新玩家
        dom.setPlayerName(req.getPlayerName());
        dom.setJob(req.getJob());
        dom.setLevel(req.getLevel());
        if (playerMapper.updateByPrimaryKeySelective(dom) > 0)
            return poToDto(dom);
        else
            throw new ResponseException(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Internal Server Error");
    }

    /**
     * 刪除
     */
    public Boolean deletePlayer(String id) {
        PlayerDto player = getPlayerInfo(id);
        return playerMapper.deleteByPrimaryKey(player.getId()) > 0;
    }

    /**
     * PO 轉 DTO
     */
    private PlayerDto poToDto(PlayerDom player) {
        PlayerDto dto = new PlayerDto();
        dto.setId(player.getId());
        dto.setJob(player.getJob());
        dto.setLevel(player.getLevel());
        dto.setPlayerName(player.getPlayerName());
        return dto;
    }
}

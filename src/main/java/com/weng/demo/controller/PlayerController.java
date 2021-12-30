package com.weng.demo.controller;

import com.weng.demo.common.CommonQuery;
import com.weng.demo.controller.dto.PlayerDto;
import com.weng.demo.res.Response;
import com.weng.demo.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.*;


@RestController
@RequestMapping(value = "/player", produces = MediaType.APPLICATION_JSON_VALUE)
public class PlayerController {
    @Autowired
    private PlayerService playerService;

    // 取得玩家資訊
    @GetMapping
    public ResponseEntity<?> getAllPlayer(@ModelAttribute CommonQuery query) {
        List<PlayerDto> dtos = playerService.getAllPlayer(query);
        Response response = new Response(HttpStatus.OK.value(), "查詢成功", dtos);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    //根據 Id 取得玩家資訊
    @GetMapping("/{id}")
    public ResponseEntity<?> getPlayerInfo(@PathVariable(name = "id") String id) {
        PlayerDto playerDto = playerService.getPlayerInfo(id);
        Response response = new Response(HttpStatus.OK.value(), "查詢成功", Collections.singletonList(playerDto));

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    // 新增玩家
    @PostMapping
    public ResponseEntity<?> newPlayer(@RequestBody PlayerDto request) {
        PlayerDto dto = playerService.newPlayer(request);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(dto.getId()).toUri();

        return ResponseEntity.created(uri).body(dto);
    }

    /**
     * 根據 Id 更新玩家
     *
     * @param id      要更改的玩家ID
     * @param request 要更改的內容
     */
    @PutMapping("/{id}")
    public ResponseEntity<?> editPlayer(@PathVariable(name = "id") String id, @RequestBody PlayerDto request) {
        PlayerDto playerDto = playerService.editPlayer(request);
        Response response = new Response(HttpStatus.OK.value(), "修改成功", Collections.singletonList(playerDto));

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    //根據 Id 刪除玩家
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePlayer(@PathVariable(name = "id") String id) {
        //遍歷並刪除id符合的玩家
        boolean delete = playerService.deletePlayer(id);
        if (delete) {
            Response response = new Response(HttpStatus.NO_CONTENT.value(), "刪除成功");
            return new ResponseEntity<>(response, HttpStatus.NO_CONTENT);
        } else {
            Response response = new Response(HttpStatus.INTERNAL_SERVER_ERROR.value(), "Internal Server Error");
            return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}

package com.weng.demo;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
public class PlayerController {

    //根據 Id 取得玩家資訊
    @GetMapping(value = "/player")
    public Player getPlayerInfo(@RequestParam(name = "id") String id) {
        Player player = new Player();
        player.setId(id);
        player.setPlayerName("鎚鎚大師");
        player.setJob("聖騎士");
        return player;
    }

    // 取得全部玩家資訊
    @GetMapping("/player")
    void getAllPlayer() {
        //取得全部玩家邏輯...回傳
    }

    // 新增玩家
    @PostMapping("/player")
    void newPlayer(@RequestParam(name = "id") String id, @RequestParam(name = "nickName") String nickName,
                   @RequestParam(name = "job") String job) {
        //新增玩家邏輯... 回傳
    }

    //根據 Id 編輯玩家
    @PutMapping("/player/{id}")
    void editPlayer(@RequestParam(name = "id") String id) {
        //編輯玩家邏輯... 回傳
    }

    //根據 Id 刪除玩家
    @DeleteMapping("/player/{id}")
    void deletePlayer(@RequestParam(name = "id") String id) {
        //刪除玩家邏輯... 回傳
    }
}

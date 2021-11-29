package com.weng.demo;

import com.weng.demo.res.Response;
import com.weng.demo.res.ResponseException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
public class PlayerController {

    // 模擬玩家的資料庫列表
    private final List<Player> playerDB = new ArrayList<>();

    // 初始化 玩家資料庫內容
    @PostConstruct
    protected void initDB() {
        playerDB.add(new Player("A0001", "鎚鎚大師", "聖騎士", 10));
        playerDB.add(new Player("A0002", "微米刺客", "刺客", 52));
        playerDB.add(new Player("A0003", "甜蜜貓咪咪", "祭司", 27));
        playerDB.add(new Player("A0004", "軟綿綿啾啾", "遊俠", 35));
        playerDB.add(new Player("A0005", "一品帶刀Lovely", "狂戰士", 73));
    }

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
    //    @GetMapping("/player")
    //    public List<Player> getAllPlayer() {
    //
    //    //      //取得全部玩家邏輯...回傳
    //    }


    // 新增玩家
    @PostMapping("/player")
    public ResponseEntity newPlayer(@RequestBody Player request) {
        // 檢查此Id是否已存在
        boolean isExistId = playerDB.stream().anyMatch(r -> r.getId().equals(request.getId()));
        if (isExistId) {
            ResponseException exception = new ResponseException(HttpStatus.UNPROCESSABLE_ENTITY.value(), "Id已存在");
            return new ResponseEntity<>(exception, HttpStatus.UNPROCESSABLE_ENTITY);
        }
        // 新增新玩家
        Player player = new Player();
        player.setId(request.getId());
        player.setPlayerName(request.getPlayerName());
        player.setJob(request.getJob());
        player.setLevel(request.getLevel());
        playerDB.add(player);

        // 回傳新增成功
        Response response = new Response(HttpStatus.CREATED.value(), "新增成功");
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
    //
    //    //根據 Id 編輯玩家
    //    @PutMapping("/player/{id}")
    //    void editPlayer(@RequestParam(name = "id") String id) {
    //        //編輯玩家邏輯... 回傳
    //    }
    //
    //    //根據 Id 刪除玩家
    //    @DeleteMapping("/player/{id}")
    //    void deletePlayer(@RequestParam(name = "id") String id) {
    //        //刪除玩家邏輯... 回傳
    //    }
}

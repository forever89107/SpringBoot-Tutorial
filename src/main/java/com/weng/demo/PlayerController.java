package com.weng.demo;

import com.sun.jndi.toolkit.url.Uri;
import com.weng.demo.res.Response;
import com.weng.demo.res.ResponseException;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.annotation.PostConstruct;
import java.net.URI;
import java.util.*;
import java.util.stream.Collectors;


@RestController
@RequestMapping(value = "/player", produces = MediaType.APPLICATION_JSON_VALUE)
public class PlayerController {

    // 模擬玩家的資料庫列表
    private final List<Player> playerDB = new ArrayList<>();

    // 初始化 玩家資料庫內容
    @PostConstruct
    protected void initDB() {
        playerDB.add(new Player("A0001", "鎚鎚大師", "初心者", 10));
        playerDB.add(new Player("A0002", "微米刺客", "刺客", 52));
        playerDB.add(new Player("A0003", "甜蜜貓咪咪", "祭司", 27));
        playerDB.add(new Player("A0004", "軟綿綿啾啾", "聖騎士", 35));
        playerDB.add(new Player("A0005", "一品帶刀Lovely", "狂戰士", 73));
    }


    // 取得玩家資訊
    @GetMapping
    public ResponseEntity getAllPlayer(@ModelAttribute CommonQuery query) {
        String sortBy = query.getSortBy();
        String sortRule = query.getSortRule();
        Comparator<Player> comparator = playerComparator(sortBy, sortRule);

        List<Player> players = playerDB.stream()
                .sorted(comparator)
                .collect(Collectors.toList());

        Response response = new Response(HttpStatus.OK.value(), "查詢成功", players);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    //根據 Id 取得玩家資訊
    @GetMapping("/{id}")
    public ResponseEntity getPlayerInfo(@PathVariable(name = "id") String id) {
        List<Player> players = playerDB.stream().filter(p -> p.getId().equals(id))
                .collect(Collectors.toList());
        Response response;
        if (players.size() == 0){
            response = new Response(HttpStatus.OK.value(), "查無此人", players);
        }else {
            response = new Response(HttpStatus.OK.value(), "查詢成功", players);
        }
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    // 新增玩家
    @PostMapping
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

        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(player.getId()).toUri();

        return ResponseEntity.created(uri).body(player);
    }

    /**
     * 根據 Id 更新玩家
     *
     * @param id      要更改的玩家ID
     * @param request 要更改的內容
     * @return
     */
    @PutMapping("/{id}")
    public ResponseEntity editPlayer(@PathVariable(name = "id") String id, @RequestBody Player request) {
        // 找出符合 id 的玩家資料
        Optional<Player> optionalPlayer = playerDB.stream().filter(p -> p.getId().equals(id)).findFirst();

        if (optionalPlayer.isPresent()) {
            Player player = optionalPlayer.get();
            player.setPlayerName(request.getPlayerName());
            player.setLevel(request.getLevel());
            player.setJob(request.getJob());

            Response response = new Response(HttpStatus.OK.value(), "修改成功", Arrays.asList(player));
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            Response response = new Response(HttpStatus.NOT_FOUND.value(), "無此Id： " + id);
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
    }

    //根據 Id 刪除玩家
    @DeleteMapping("/{id}")
    public ResponseEntity deletePlayer(@PathVariable(name = "id") String id) {
        //遍歷並刪除id符合的玩家
        boolean delete = playerDB.removeIf(p -> p.getId().equals(id));
        if (delete) {
            Response response = new Response(HttpStatus.NO_CONTENT.value(), "刪除成功");
            return new ResponseEntity<>(response, HttpStatus.NO_CONTENT);
        } else {
            Response response = new Response(HttpStatus.NOT_FOUND.value(), "無此Id： " + id);
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
    }

    /**
     * 比較器方法
     */
    private Comparator<Player> playerComparator(String sortBy, String sortRule) {
        Comparator<Player> comparator = (o1, o2) -> (0);
        // 如條件不齊全，直接返回
        if (Objects.isNull(sortBy) || Objects.isNull(sortRule)) return comparator;

        if (sortBy.equalsIgnoreCase("id")) {
            comparator = Comparator.comparing(Player::getId);
        } else if (sortBy.equalsIgnoreCase("level")) {
            comparator = Comparator.comparing(Player::getLevel);
        }
        return sortRule.equalsIgnoreCase("asc") ? comparator : comparator.reversed();
    }
}

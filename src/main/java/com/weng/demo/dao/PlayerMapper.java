package com.weng.demo.dao;

import com.weng.demo.service.po.Player;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

/**
 * DAO
 */

@Mapper
public interface PlayerMapper {

    @Select("select * from `player` where id = #{id}")
    @Results({
            @Result(column="id", property="id", jdbcType= JdbcType.VARCHAR, id=true),
            @Result(column="player_name", property="playerName", jdbcType=JdbcType.VARCHAR),
            @Result(column="job", property="job", jdbcType=JdbcType.VARCHAR),
            @Result(column="level", property="level", jdbcType=JdbcType.INTEGER)
    })
    Player findById(@Param("id") String id);
}

package com.weng.demo.dao;

import com.weng.demo.dao.generate.dao.PlayerDomMapper;
import com.weng.demo.service.po.Player;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;

/**
 * DAO
 */

@Mapper
public interface PlayerMapper extends PlayerDomMapper {
    //可自行定義、客製化SQL語法
}

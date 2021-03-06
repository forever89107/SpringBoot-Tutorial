package com.weng.demo.dao.generate.dao;

import com.weng.demo.dao.generate.po.PlayerDom;
import com.weng.demo.dao.generate.po.PlayerDomExample;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.DeleteProvider;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.Update;
import org.apache.ibatis.annotations.UpdateProvider;
import org.apache.ibatis.type.JdbcType;

public interface PlayerDomMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table player
     *
     * @mbg.generated Tue Dec 28 16:50:20 CST 2021
     */
    @SelectProvider(type=PlayerDomSqlProvider.class, method="countByExample")
    long countByExample(PlayerDomExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table player
     *
     * @mbg.generated Tue Dec 28 16:50:20 CST 2021
     */
    @DeleteProvider(type=PlayerDomSqlProvider.class, method="deleteByExample")
    int deleteByExample(PlayerDomExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table player
     *
     * @mbg.generated Tue Dec 28 16:50:20 CST 2021
     */
    @Delete({
        "delete from player",
        "where id = #{id,jdbcType=VARCHAR}"
    })
    int deleteByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table player
     *
     * @mbg.generated Tue Dec 28 16:50:20 CST 2021
     */
    @Insert({
        "insert into player (id, player_name, ",
        "job, level)",
        "values (#{id,jdbcType=VARCHAR}, #{playerName,jdbcType=VARCHAR}, ",
        "#{job,jdbcType=VARCHAR}, #{level,jdbcType=INTEGER})"
    })
    int insert(PlayerDom record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table player
     *
     * @mbg.generated Tue Dec 28 16:50:20 CST 2021
     */
    @InsertProvider(type=PlayerDomSqlProvider.class, method="insertSelective")
    int insertSelective(PlayerDom record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table player
     *
     * @mbg.generated Tue Dec 28 16:50:20 CST 2021
     */
    @SelectProvider(type=PlayerDomSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="player_name", property="playerName", jdbcType=JdbcType.VARCHAR),
        @Result(column="job", property="job", jdbcType=JdbcType.VARCHAR),
        @Result(column="level", property="level", jdbcType=JdbcType.INTEGER)
    })
    List<PlayerDom> selectByExample(PlayerDomExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table player
     *
     * @mbg.generated Tue Dec 28 16:50:20 CST 2021
     */
    @Select({
        "select",
        "id, player_name, job, level",
        "from player",
        "where id = #{id,jdbcType=VARCHAR}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.VARCHAR, id=true),
        @Result(column="player_name", property="playerName", jdbcType=JdbcType.VARCHAR),
        @Result(column="job", property="job", jdbcType=JdbcType.VARCHAR),
        @Result(column="level", property="level", jdbcType=JdbcType.INTEGER)
    })
    PlayerDom selectByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table player
     *
     * @mbg.generated Tue Dec 28 16:50:20 CST 2021
     */
    @UpdateProvider(type=PlayerDomSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") PlayerDom record, @Param("example") PlayerDomExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table player
     *
     * @mbg.generated Tue Dec 28 16:50:20 CST 2021
     */
    @UpdateProvider(type=PlayerDomSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") PlayerDom record, @Param("example") PlayerDomExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table player
     *
     * @mbg.generated Tue Dec 28 16:50:20 CST 2021
     */
    @UpdateProvider(type=PlayerDomSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(PlayerDom record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table player
     *
     * @mbg.generated Tue Dec 28 16:50:20 CST 2021
     */
    @Update({
        "update player",
        "set player_name = #{playerName,jdbcType=VARCHAR},",
          "job = #{job,jdbcType=VARCHAR},",
          "level = #{level,jdbcType=INTEGER}",
        "where id = #{id,jdbcType=VARCHAR}"
    })
    int updateByPrimaryKey(PlayerDom record);
}
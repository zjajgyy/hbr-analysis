package com.bigdata.hbr.mapper;

import com.bigdata.hbr.entity.UserResult;
import com.bigdata.hbr.entity.UserResultExample;
import java.util.List;
import org.apache.ibatis.annotations.Delete;
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

public interface UserResultMapper {
    @Delete({
        "delete from user_result",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into user_result (id, username, ",
        "sd1, sd2, health_status, ",
        "log_time)",
        "values (#{id,jdbcType=INTEGER}, #{username,jdbcType=VARCHAR}, ",
        "#{sd1,jdbcType=DOUBLE}, #{sd2,jdbcType=DOUBLE}, #{healthStatus,jdbcType=VARCHAR}, ",
        "#{logTime,jdbcType=TIMESTAMP})"
    })
    int insert(UserResult record);

    @InsertProvider(type=UserResultSqlProvider.class, method="insertSelective")
    int insertSelective(UserResult record);

    @SelectProvider(type=UserResultSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="username", property="username", jdbcType=JdbcType.VARCHAR),
        @Result(column="sd1", property="sd1", jdbcType=JdbcType.DOUBLE),
        @Result(column="sd2", property="sd2", jdbcType=JdbcType.DOUBLE),
        @Result(column="health_status", property="healthStatus", jdbcType=JdbcType.VARCHAR),
        @Result(column="log_time", property="logTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<UserResult> selectByExample(UserResultExample example);

    @Select({
            "select",
            "id, username, sd1, sd2, health_status, log_time",
            "from user_result",
            "where username = #{username,jdbcType=INTEGER}"
    })
    @Results({
            @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
            @Result(column="username", property="username", jdbcType=JdbcType.VARCHAR),
            @Result(column="sd1", property="sd1", jdbcType=JdbcType.DOUBLE),
            @Result(column="sd2", property="sd2", jdbcType=JdbcType.DOUBLE),
            @Result(column="health_status", property="healthStatus", jdbcType=JdbcType.VARCHAR),
            @Result(column="log_time", property="logTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<UserResult> selectByPrimaryKey(String username);

    @UpdateProvider(type=UserResultSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") UserResult record, @Param("example") UserResultExample example);

    @UpdateProvider(type=UserResultSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") UserResult record, @Param("example") UserResultExample example);

    @UpdateProvider(type=UserResultSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(UserResult record);

    @Update({
        "update user_result",
        "set username = #{username,jdbcType=VARCHAR},",
          "sd1 = #{sd1,jdbcType=DOUBLE},",
          "sd2 = #{sd2,jdbcType=DOUBLE},",
          "health_status = #{healthStatus,jdbcType=VARCHAR},",
          "log_time = #{logTime,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(UserResult record);
}
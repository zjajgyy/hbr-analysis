package com.bigdata.hbr.mapper;

import com.bigdata.hbr.entity.PatientResult;
import com.bigdata.hbr.entity.PatientResultExample;
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

public interface PatientResultMapper {
    @Delete({
        "delete from patient_result",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Insert({
        "insert into patient_result (id, patient_id, ",
        "sd1, sd2, health_status, ",
        "log_time)",
        "values (#{id,jdbcType=INTEGER}, #{patientId,jdbcType=INTEGER}, ",
        "#{sd1,jdbcType=DOUBLE}, #{sd2,jdbcType=DOUBLE}, #{healthStatus,jdbcType=VARCHAR}, ",
        "#{logTime,jdbcType=TIMESTAMP})"
    })
    int insert(PatientResult record);

    @InsertProvider(type=PatientResultSqlProvider.class, method="insertSelective")
    int insertSelective(PatientResult record);

    @SelectProvider(type=PatientResultSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="patient_id", property="patientId", jdbcType=JdbcType.INTEGER),
        @Result(column="sd1", property="sd1", jdbcType=JdbcType.DOUBLE),
        @Result(column="sd2", property="sd2", jdbcType=JdbcType.DOUBLE),
        @Result(column="health_status", property="healthStatus", jdbcType=JdbcType.VARCHAR),
        @Result(column="log_time", property="logTime", jdbcType=JdbcType.TIMESTAMP)
    })
    List<PatientResult> selectByExample(PatientResultExample example);

    @Select({
        "select",
        "id, patient_id, sd1, sd2, health_status, log_time",
        "from patient_result",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="patient_id", property="patientId", jdbcType=JdbcType.INTEGER),
        @Result(column="sd1", property="sd1", jdbcType=JdbcType.DOUBLE),
        @Result(column="sd2", property="sd2", jdbcType=JdbcType.DOUBLE),
        @Result(column="health_status", property="healthStatus", jdbcType=JdbcType.VARCHAR),
        @Result(column="log_time", property="logTime", jdbcType=JdbcType.TIMESTAMP)
    })
    PatientResult selectByPrimaryKey(Integer id);

    @UpdateProvider(type=PatientResultSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") PatientResult record, @Param("example") PatientResultExample example);

    @UpdateProvider(type=PatientResultSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") PatientResult record, @Param("example") PatientResultExample example);

    @UpdateProvider(type=PatientResultSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(PatientResult record);

    @Update({
        "update patient_result",
        "set patient_id = #{patientId,jdbcType=INTEGER},",
          "sd1 = #{sd1,jdbcType=DOUBLE},",
          "sd2 = #{sd2,jdbcType=DOUBLE},",
          "health_status = #{healthStatus,jdbcType=VARCHAR},",
          "log_time = #{logTime,jdbcType=TIMESTAMP}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(PatientResult record);
}
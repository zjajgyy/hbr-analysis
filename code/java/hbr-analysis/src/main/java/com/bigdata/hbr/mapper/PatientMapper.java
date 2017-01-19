package com.bigdata.hbr.mapper;

import com.bigdata.hbr.entity.Patient;
import com.bigdata.hbr.entity.PatientExample;
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

public interface PatientMapper {
    @Delete({
        "delete from patient",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int deleteByPrimaryKey(Integer id);

    @Delete({
            "delete from patient",
            "where name = #{name,jdbcType=INTEGER}"
    })
    int deleteByName(String name);

    @Insert({
        "insert into patient (id, name, ",
        "gender, position, doctor_login_name, ",
        "heart_identifier, sd1, ",
        "sd2, health_status, ",
        "treat_status)",
        "values (#{id,jdbcType=INTEGER}, #{name,jdbcType=VARCHAR}, ",
        "#{gender,jdbcType=CHAR}, #{position,jdbcType=VARCHAR}, #{doctorLoginName,jdbcType=VARCHAR}, ",
        "#{heartIdentifier,jdbcType=VARCHAR}, #{sd1,jdbcType=DOUBLE}, ",
        "#{sd2,jdbcType=DOUBLE}, #{healthStatus,jdbcType=VARCHAR}, ",
        "#{treatStatus,jdbcType=VARCHAR})"
    })
    int insert(Patient record);

    @InsertProvider(type=PatientSqlProvider.class, method="insertSelective")
    int insertSelective(Patient record);

    @SelectProvider(type=PatientSqlProvider.class, method="selectByExample")
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="gender", property="gender", jdbcType=JdbcType.CHAR),
        @Result(column="position", property="position", jdbcType=JdbcType.VARCHAR),
        @Result(column="doctor_login_name", property="doctorLoginName", jdbcType=JdbcType.VARCHAR),
        @Result(column="heart_identifier", property="heartIdentifier", jdbcType=JdbcType.VARCHAR),
        @Result(column="sd1", property="sd1", jdbcType=JdbcType.DOUBLE),
        @Result(column="sd2", property="sd2", jdbcType=JdbcType.DOUBLE),
        @Result(column="health_status", property="healthStatus", jdbcType=JdbcType.VARCHAR),
        @Result(column="treat_status", property="treatStatus", jdbcType=JdbcType.VARCHAR)
    })
    List<Patient> selectByExample(PatientExample example);

    @Select({
        "select",
        "id, name, gender, position, doctor_login_name, heart_identifier, sd1, sd2, health_status, ",
        "treat_status",
        "from patient",
        "where id = #{id,jdbcType=INTEGER}"
    })
    @Results({
        @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
        @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
        @Result(column="gender", property="gender", jdbcType=JdbcType.CHAR),
        @Result(column="position", property="position", jdbcType=JdbcType.VARCHAR),
        @Result(column="doctor_login_name", property="doctorLoginName", jdbcType=JdbcType.VARCHAR),
        @Result(column="heart_identifier", property="heartIdentifier", jdbcType=JdbcType.VARCHAR),
        @Result(column="sd1", property="sd1", jdbcType=JdbcType.DOUBLE),
        @Result(column="sd2", property="sd2", jdbcType=JdbcType.DOUBLE),
        @Result(column="health_status", property="healthStatus", jdbcType=JdbcType.VARCHAR),
        @Result(column="treat_status", property="treatStatus", jdbcType=JdbcType.VARCHAR)
    })
    Patient selectByPrimaryKey(Integer id);

    @Select({
            "select",
            "id, name, gender, position, doctor_login_name, heart_identifier, sd1, sd2, health_status, ",
            "treat_status",
            "from patient",
            "where doctor_login_name = #{username,jdbcType=VARCHAR}"
    })
    @Results({
            @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
            @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
            @Result(column="gender", property="gender", jdbcType=JdbcType.CHAR),
            @Result(column="position", property="position", jdbcType=JdbcType.VARCHAR),
            @Result(column="doctor_login_name", property="doctorLoginName", jdbcType=JdbcType.VARCHAR),
            @Result(column="heart_identifier", property="heartIdentifier", jdbcType=JdbcType.VARCHAR),
            @Result(column="sd1", property="sd1", jdbcType=JdbcType.DOUBLE),
            @Result(column="sd2", property="sd2", jdbcType=JdbcType.DOUBLE),
            @Result(column="health_status", property="healthStatus", jdbcType=JdbcType.VARCHAR),
            @Result(column="treat_status", property="treatStatus", jdbcType=JdbcType.VARCHAR)
    })
    List<Patient> selectByName(String username);

    @Select({
            "select",
            "id, name, gender, position, doctor_login_name, heart_identifier, sd1, sd2, health_status, ",
            "treat_status",
            "from patient"
    })
    @Results({
            @Result(column="id", property="id", jdbcType=JdbcType.INTEGER, id=true),
            @Result(column="name", property="name", jdbcType=JdbcType.VARCHAR),
            @Result(column="gender", property="gender", jdbcType=JdbcType.CHAR),
            @Result(column="position", property="position", jdbcType=JdbcType.VARCHAR),
            @Result(column="doctor_login_name", property="doctorLoginName", jdbcType=JdbcType.VARCHAR),
            @Result(column="heart_identifier", property="heartIdentifier", jdbcType=JdbcType.VARCHAR),
            @Result(column="sd1", property="sd1", jdbcType=JdbcType.DOUBLE),
            @Result(column="sd2", property="sd2", jdbcType=JdbcType.DOUBLE),
            @Result(column="health_status", property="healthStatus", jdbcType=JdbcType.VARCHAR),
            @Result(column="treat_status", property="treatStatus", jdbcType=JdbcType.VARCHAR)
    })
    List<Patient> selectAll();

    @UpdateProvider(type=PatientSqlProvider.class, method="updateByExampleSelective")
    int updateByExampleSelective(@Param("record") Patient record, @Param("example") PatientExample example);

    @UpdateProvider(type=PatientSqlProvider.class, method="updateByExample")
    int updateByExample(@Param("record") Patient record, @Param("example") PatientExample example);

    @UpdateProvider(type=PatientSqlProvider.class, method="updateByPrimaryKeySelective")
    int updateByPrimaryKeySelective(Patient record);

    @Update({
        "update patient",
        "set name = #{name,jdbcType=VARCHAR},",
          "gender = #{gender,jdbcType=CHAR},",
          "position = #{position,jdbcType=VARCHAR},",
          "doctor_login_name = #{doctorLoginName,jdbcType=VARCHAR},",
          "heart_identifier = #{heartIdentifier,jdbcType=VARCHAR},",
          "sd1 = #{sd1,jdbcType=DOUBLE},",
          "sd2 = #{sd2,jdbcType=DOUBLE},",
          "health_status = #{healthStatus,jdbcType=VARCHAR},",
          "treat_status = #{treatStatus,jdbcType=VARCHAR}",
        "where id = #{id,jdbcType=INTEGER}"
    })
    int updateByPrimaryKey(Patient record);
}
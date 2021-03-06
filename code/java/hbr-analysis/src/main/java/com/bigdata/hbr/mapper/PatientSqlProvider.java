package com.bigdata.hbr.mapper;

import com.bigdata.hbr.entity.Patient;
import com.bigdata.hbr.entity.PatientExample.Criteria;
import com.bigdata.hbr.entity.PatientExample.Criterion;
import com.bigdata.hbr.entity.PatientExample;
import java.util.List;
import java.util.Map;
import org.apache.ibatis.jdbc.SQL;

public class PatientSqlProvider {

    public String insertSelective(Patient record) {
        SQL sql = new SQL();
        sql.INSERT_INTO("patient");
        
        if (record.getId() != null) {
            sql.VALUES("id", "#{id,jdbcType=INTEGER}");
        }
        
        if (record.getName() != null) {
            sql.VALUES("name", "#{name,jdbcType=VARCHAR}");
        }
        
        if (record.getGender() != null) {
            sql.VALUES("gender", "#{gender,jdbcType=CHAR}");
        }
        
        if (record.getPosition() != null) {
            sql.VALUES("position", "#{position,jdbcType=VARCHAR}");
        }
        
        if (record.getDoctorLoginName() != null) {
            sql.VALUES("doctor_login_name", "#{doctorLoginName,jdbcType=VARCHAR}");
        }
        
        if (record.getHeartIdentifier() != null) {
            sql.VALUES("heart_identifier", "#{heartIdentifier,jdbcType=VARCHAR}");
        }
        
        if (record.getSd1() != null) {
            sql.VALUES("sd1", "#{sd1,jdbcType=DOUBLE}");
        }
        
        if (record.getSd2() != null) {
            sql.VALUES("sd2", "#{sd2,jdbcType=DOUBLE}");
        }
        
        if (record.getHealthStatus() != null) {
            sql.VALUES("health_status", "#{healthStatus,jdbcType=VARCHAR}");
        }
        
        if (record.getTreatStatus() != null) {
            sql.VALUES("treat_status", "#{treatStatus,jdbcType=VARCHAR}");
        }
        
        return sql.toString();
    }

    public String selectByExample(PatientExample example) {
        SQL sql = new SQL();
        if (example != null && example.isDistinct()) {
            sql.SELECT_DISTINCT("id");
        } else {
            sql.SELECT("id");
        }
        sql.SELECT("name");
        sql.SELECT("gender");
        sql.SELECT("position");
        sql.SELECT("doctor_login_name");
        sql.SELECT("heart_identifier");
        sql.SELECT("sd1");
        sql.SELECT("sd2");
        sql.SELECT("health_status");
        sql.SELECT("treat_status");
        sql.FROM("patient");
        applyWhere(sql, example, false);
        
        if (example != null && example.getOrderByClause() != null) {
            sql.ORDER_BY(example.getOrderByClause());
        }
        
        return sql.toString();
    }

    public String updateByExampleSelective(Map<String, Object> parameter) {
        Patient record = (Patient) parameter.get("record");
        PatientExample example = (PatientExample) parameter.get("example");
        
        SQL sql = new SQL();
        sql.UPDATE("patient");
        
        if (record.getId() != null) {
            sql.SET("id = #{record.id,jdbcType=INTEGER}");
        }
        
        if (record.getName() != null) {
            sql.SET("name = #{record.name,jdbcType=VARCHAR}");
        }
        
        if (record.getGender() != null) {
            sql.SET("gender = #{record.gender,jdbcType=CHAR}");
        }
        
        if (record.getPosition() != null) {
            sql.SET("position = #{record.position,jdbcType=VARCHAR}");
        }
        
        if (record.getDoctorLoginName() != null) {
            sql.SET("doctor_login_name = #{record.doctorLoginName,jdbcType=VARCHAR}");
        }
        
        if (record.getHeartIdentifier() != null) {
            sql.SET("heart_identifier = #{record.heartIdentifier,jdbcType=VARCHAR}");
        }
        
        if (record.getSd1() != null) {
            sql.SET("sd1 = #{record.sd1,jdbcType=DOUBLE}");
        }
        
        if (record.getSd2() != null) {
            sql.SET("sd2 = #{record.sd2,jdbcType=DOUBLE}");
        }
        
        if (record.getHealthStatus() != null) {
            sql.SET("health_status = #{record.healthStatus,jdbcType=VARCHAR}");
        }
        
        if (record.getTreatStatus() != null) {
            sql.SET("treat_status = #{record.treatStatus,jdbcType=VARCHAR}");
        }
        
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByExample(Map<String, Object> parameter) {
        SQL sql = new SQL();
        sql.UPDATE("patient");
        
        sql.SET("id = #{record.id,jdbcType=INTEGER}");
        sql.SET("name = #{record.name,jdbcType=VARCHAR}");
        sql.SET("gender = #{record.gender,jdbcType=CHAR}");
        sql.SET("position = #{record.position,jdbcType=VARCHAR}");
        sql.SET("doctor_login_name = #{record.doctorLoginName,jdbcType=VARCHAR}");
        sql.SET("heart_identifier = #{record.heartIdentifier,jdbcType=VARCHAR}");
        sql.SET("sd1 = #{record.sd1,jdbcType=DOUBLE}");
        sql.SET("sd2 = #{record.sd2,jdbcType=DOUBLE}");
        sql.SET("health_status = #{record.healthStatus,jdbcType=VARCHAR}");
        sql.SET("treat_status = #{record.treatStatus,jdbcType=VARCHAR}");
        
        PatientExample example = (PatientExample) parameter.get("example");
        applyWhere(sql, example, true);
        return sql.toString();
    }

    public String updateByPrimaryKeySelective(Patient record) {
        SQL sql = new SQL();
        sql.UPDATE("patient");
        
        if (record.getName() != null) {
            sql.SET("name = #{name,jdbcType=VARCHAR}");
        }
        
        if (record.getGender() != null) {
            sql.SET("gender = #{gender,jdbcType=CHAR}");
        }
        
        if (record.getPosition() != null) {
            sql.SET("position = #{position,jdbcType=VARCHAR}");
        }
        
        if (record.getDoctorLoginName() != null) {
            sql.SET("doctor_login_name = #{doctorLoginName,jdbcType=VARCHAR}");
        }
        
        if (record.getHeartIdentifier() != null) {
            sql.SET("heart_identifier = #{heartIdentifier,jdbcType=VARCHAR}");
        }
        
        if (record.getSd1() != null) {
            sql.SET("sd1 = #{sd1,jdbcType=DOUBLE}");
        }
        
        if (record.getSd2() != null) {
            sql.SET("sd2 = #{sd2,jdbcType=DOUBLE}");
        }
        
        if (record.getHealthStatus() != null) {
            sql.SET("health_status = #{healthStatus,jdbcType=VARCHAR}");
        }
        
        if (record.getTreatStatus() != null) {
            sql.SET("treat_status = #{treatStatus,jdbcType=VARCHAR}");
        }
        
        sql.WHERE("id = #{id,jdbcType=INTEGER}");
        
        return sql.toString();
    }

    protected void applyWhere(SQL sql, PatientExample example, boolean includeExamplePhrase) {
        if (example == null) {
            return;
        }
        
        String parmPhrase1;
        String parmPhrase1_th;
        String parmPhrase2;
        String parmPhrase2_th;
        String parmPhrase3;
        String parmPhrase3_th;
        if (includeExamplePhrase) {
            parmPhrase1 = "%s #{example.oredCriteria[%d].allCriteria[%d].value}";
            parmPhrase1_th = "%s #{example.oredCriteria[%d].allCriteria[%d].value,typeHandler=%s}";
            parmPhrase2 = "%s #{example.oredCriteria[%d].allCriteria[%d].value} and #{example.oredCriteria[%d].criteria[%d].secondValue}";
            parmPhrase2_th = "%s #{example.oredCriteria[%d].allCriteria[%d].value,typeHandler=%s} and #{example.oredCriteria[%d].criteria[%d].secondValue,typeHandler=%s}";
            parmPhrase3 = "#{example.oredCriteria[%d].allCriteria[%d].value[%d]}";
            parmPhrase3_th = "#{example.oredCriteria[%d].allCriteria[%d].value[%d],typeHandler=%s}";
        } else {
            parmPhrase1 = "%s #{oredCriteria[%d].allCriteria[%d].value}";
            parmPhrase1_th = "%s #{oredCriteria[%d].allCriteria[%d].value,typeHandler=%s}";
            parmPhrase2 = "%s #{oredCriteria[%d].allCriteria[%d].value} and #{oredCriteria[%d].criteria[%d].secondValue}";
            parmPhrase2_th = "%s #{oredCriteria[%d].allCriteria[%d].value,typeHandler=%s} and #{oredCriteria[%d].criteria[%d].secondValue,typeHandler=%s}";
            parmPhrase3 = "#{oredCriteria[%d].allCriteria[%d].value[%d]}";
            parmPhrase3_th = "#{oredCriteria[%d].allCriteria[%d].value[%d],typeHandler=%s}";
        }
        
        StringBuilder sb = new StringBuilder();
        List<Criteria> oredCriteria = example.getOredCriteria();
        boolean firstCriteria = true;
        for (int i = 0; i < oredCriteria.size(); i++) {
            Criteria criteria = oredCriteria.get(i);
            if (criteria.isValid()) {
                if (firstCriteria) {
                    firstCriteria = false;
                } else {
                    sb.append(" or ");
                }
                
                sb.append('(');
                List<Criterion> criterions = criteria.getAllCriteria();
                boolean firstCriterion = true;
                for (int j = 0; j < criterions.size(); j++) {
                    Criterion criterion = criterions.get(j);
                    if (firstCriterion) {
                        firstCriterion = false;
                    } else {
                        sb.append(" and ");
                    }
                    
                    if (criterion.isNoValue()) {
                        sb.append(criterion.getCondition());
                    } else if (criterion.isSingleValue()) {
                        if (criterion.getTypeHandler() == null) {
                            sb.append(String.format(parmPhrase1, criterion.getCondition(), i, j));
                        } else {
                            sb.append(String.format(parmPhrase1_th, criterion.getCondition(), i, j,criterion.getTypeHandler()));
                        }
                    } else if (criterion.isBetweenValue()) {
                        if (criterion.getTypeHandler() == null) {
                            sb.append(String.format(parmPhrase2, criterion.getCondition(), i, j, i, j));
                        } else {
                            sb.append(String.format(parmPhrase2_th, criterion.getCondition(), i, j, criterion.getTypeHandler(), i, j, criterion.getTypeHandler()));
                        }
                    } else if (criterion.isListValue()) {
                        sb.append(criterion.getCondition());
                        sb.append(" (");
                        List<?> listItems = (List<?>) criterion.getValue();
                        boolean comma = false;
                        for (int k = 0; k < listItems.size(); k++) {
                            if (comma) {
                                sb.append(", ");
                            } else {
                                comma = true;
                            }
                            if (criterion.getTypeHandler() == null) {
                                sb.append(String.format(parmPhrase3, i, j, k));
                            } else {
                                sb.append(String.format(parmPhrase3_th, i, j, k, criterion.getTypeHandler()));
                            }
                        }
                        sb.append(')');
                    }
                }
                sb.append(')');
            }
        }
        
        if (sb.length() > 0) {
            sql.WHERE(sb.toString());
        }
    }
}
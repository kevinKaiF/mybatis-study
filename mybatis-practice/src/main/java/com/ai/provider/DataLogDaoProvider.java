package com.ai.provider;

import com.ai.entity.DataLog;
import org.apache.ibatis.jdbc.SQL;

/**
 * @author : kevin
 * @version : Ver 1.0
 * @description :
 * @date : 2017/10/27
 */
public class DataLogDaoProvider {
//    public String findByCondition(@Param("id") String id, @Param("instanceName")String instanceName, String message) {
    public String findByCondition(DataLog dataLog) {
//                <if test="id != null">
//                         AND ID = #{id}
//                </if>
//                if (id != null) {
//                    WHERE()
//                }
//                <if test="instanceName != null and instanceName !=''">
//                         AND INSTANCE_NAME = #{instanceName}
//                </if>
//                <if test="message != null and message !=''">
//                         AND MESSAGE = #{message}
//                </if>
//                <if test="createTimeBegin != null">
//                         AND CREATE_TIME >= #{createTimeBegin}
//                </if>
//                <if test="createTimeEnd != null">
//                         AND CREATE_TIME &lt;= #{createTimeEnd}
//                </if>
        SQL sql = new SQL().SELECT("ID,INSTANCE_NAME,CREATE_TIME").FROM("data_log");
        if (dataLog.getId() != null) {
            sql.WHERE("ID = #{id}");
        }

        if (dataLog.getInstanceName() != null) {
            sql.OR().WHERE("INSTANCE_NAME = #{instanceName}");
        }



        String s = sql.toString();
        System.out.println("sql:\n" + s);
        return s;
    }
}

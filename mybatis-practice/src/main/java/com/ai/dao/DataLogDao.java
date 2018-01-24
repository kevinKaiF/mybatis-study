package com.ai.dao;

import com.ai.entity.DataLog;
import com.ai.provider.DataLogDaoProvider;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;

import java.util.List;

/**
 * @author : kevin
 * @version : Ver 1.0
 * @description :
 * @date : 2017/6/5
 */
public interface DataLogDao {
    void insert(DataLog dataLog);

    void update(DataLog dataLog);

    void delete(@Param("id") Long id);

    @Select("SELECT * FROM data_log WHERE id = #{id}")
    DataLog getById(@Param("id") Long id);

    Long countByCondition(DataLog dataLog);

    @SelectProvider(type = DataLogDaoProvider.class, method = "findByCondition")
    List<DataLog> findByCondition(DataLog dataLog);

    List<DataLog> findByConditionFully(DataLog dataLog);

    void deleteByCondition(DataLog dataLog);
}

package com.ljj.ceet.mapper;

import com.ljj.ceet.entity.EmployeeInf;
import com.ljj.ceet.entity.EmployeeInfExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeInfMapper {
    int countByExample(EmployeeInfExample example);

    int deleteByExample(EmployeeInfExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(EmployeeInf record);

    int insertSelective(EmployeeInf record);

    List<EmployeeInf> selectByExample(EmployeeInfExample example);

    EmployeeInf selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") EmployeeInf record, @Param("example") EmployeeInfExample example);

    int updateByExample(@Param("record") EmployeeInf record, @Param("example") EmployeeInfExample example);

    int updateByPrimaryKeySelective(EmployeeInf record);

    int updateByPrimaryKey(EmployeeInf record);
}
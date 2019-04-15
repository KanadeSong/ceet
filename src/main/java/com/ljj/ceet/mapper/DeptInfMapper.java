package com.ljj.ceet.mapper;

import com.ljj.ceet.entity.DeptInf;
import com.ljj.ceet.entity.DeptInfExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DeptInfMapper {
    int countByExample(DeptInfExample example);

    int deleteByExample(DeptInfExample example);

    int deleteByPrimaryKey(String id);

    int insert(DeptInf record);

    int insertSelective(DeptInf record);

    List<DeptInf> selectByExample(DeptInfExample example);

    DeptInf selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") DeptInf record, @Param("example") DeptInfExample example);

    int updateByExample(@Param("record") DeptInf record, @Param("example") DeptInfExample example);

    int updateByPrimaryKeySelective(DeptInf record);

    int updateByPrimaryKey(DeptInf record);
}
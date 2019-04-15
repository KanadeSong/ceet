package com.ljj.ceet.mapper;

import com.ljj.ceet.entity.UserInf;
import com.ljj.ceet.entity.UserInfExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface UserInfMapper {
    int countByExample(UserInfExample example);

    int deleteByExample(UserInfExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(UserInf record);

    int insertSelective(UserInf record);

    List<UserInf> selectByExample(UserInfExample example);

    UserInf selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") UserInf record, @Param("example") UserInfExample example);

    int updateByExample(@Param("record") UserInf record, @Param("example") UserInfExample example);

    int updateByPrimaryKeySelective(String record);

    int updateByPrimaryKey(UserInf record);
}
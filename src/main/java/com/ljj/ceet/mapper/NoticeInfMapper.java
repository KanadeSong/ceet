package com.ljj.ceet.mapper;

import com.ljj.ceet.entity.NoticeInf;
import com.ljj.ceet.entity.NoticeInfExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NoticeInfMapper {
    int countByExample(NoticeInfExample example);

    int deleteByExample(NoticeInfExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(NoticeInf record);

    int insertSelective(NoticeInf record);

    List<NoticeInf> selectByExampleWithBLOBs(NoticeInfExample example);

    List<NoticeInf> selectByExample(NoticeInfExample example);

    NoticeInf selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") NoticeInf record, @Param("example") NoticeInfExample example);

    int updateByExampleWithBLOBs(@Param("record") NoticeInf record, @Param("example") NoticeInfExample example);

    int updateByExample(@Param("record") NoticeInf record, @Param("example") NoticeInfExample example);

    int updateByPrimaryKeySelective(NoticeInf record);

    int updateByPrimaryKeyWithBLOBs(NoticeInf record);

    int updateByPrimaryKey(NoticeInf record);
}
package com.ljj.ceet.mapper;

import com.ljj.ceet.entity.DocumentInf;
import com.ljj.ceet.entity.DocumentInfExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DocumentInfMapper {
    int countByExample(DocumentInfExample example);

    int deleteByExample(DocumentInfExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(DocumentInf record);

    int insertSelective(DocumentInf record);

    List<DocumentInf> selectByExample(DocumentInfExample example);

    DocumentInf selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") DocumentInf record, @Param("example") DocumentInfExample example);

    int updateByExample(@Param("record") DocumentInf record, @Param("example") DocumentInfExample example);

    int updateByPrimaryKeySelective(DocumentInf record);

    int updateByPrimaryKey(DocumentInf record);
}
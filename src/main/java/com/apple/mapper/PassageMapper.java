package com.apple.mapper;

import com.apple.pojo.Passage;
import com.apple.pojo.PassageExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PassageMapper {
    int countByExample(PassageExample example);

    int deleteByExample(PassageExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Passage record);

    int insertSelective(Passage record);

    List<Passage> selectByExample(PassageExample example);

    Passage selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Passage record, @Param("example") PassageExample example);

    int updateByExample(@Param("record") Passage record, @Param("example") PassageExample example);

    int updateByPrimaryKeySelective(Passage record);

    int updateByPrimaryKey(Passage record);
}
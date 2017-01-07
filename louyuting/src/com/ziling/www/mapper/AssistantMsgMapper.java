package com.ziling.www.mapper;

import com.ziling.www.po.AssistantMsg;
import com.ziling.www.po.AssistantMsgExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AssistantMsgMapper {
    int countByExample(AssistantMsgExample example);

    int deleteByExample(AssistantMsgExample example);

    int deleteByPrimaryKey(String id);

    int insert(AssistantMsg record);

    int insertSelective(AssistantMsg record);

    List<AssistantMsg> selectByExample(AssistantMsgExample example);

    AssistantMsg selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") AssistantMsg record, @Param("example") AssistantMsgExample example);

    int updateByExample(@Param("record") AssistantMsg record, @Param("example") AssistantMsgExample example);

    int updateByPrimaryKeySelective(AssistantMsg record);

    int updateByPrimaryKey(AssistantMsg record);
}
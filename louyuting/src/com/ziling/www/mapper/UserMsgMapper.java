package com.ziling.www.mapper;

import com.ziling.www.po.UserMsg;
import com.ziling.www.po.UserMsgExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserMsgMapper {
    int countByExample(UserMsgExample example);

    int deleteByExample(UserMsgExample example);

    int deleteByPrimaryKey(String msgId);

    int insert(UserMsg record);

    int insertSelective(UserMsg record);

    List<UserMsg> selectByExample(UserMsgExample example);

    UserMsg selectByPrimaryKey(String msgId);

    int updateByExampleSelective(@Param("record") UserMsg record, @Param("netty/example") UserMsgExample example);

    int updateByExample(@Param("record") UserMsg record, @Param("netty/example") UserMsgExample example);

    int updateByPrimaryKeySelective(UserMsg record);

    int updateByPrimaryKey(UserMsg record);
}
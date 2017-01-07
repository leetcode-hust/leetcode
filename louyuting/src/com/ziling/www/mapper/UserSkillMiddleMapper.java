package com.ziling.www.mapper;

import com.ziling.www.po.UserSkillMiddle;
import com.ziling.www.po.UserSkillMiddleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserSkillMiddleMapper {
    int countByExample(UserSkillMiddleExample example);

    int deleteByExample(UserSkillMiddleExample example);

    int deleteByPrimaryKey(String id);

    int insert(UserSkillMiddle record);

    int insertSelective(UserSkillMiddle record);

    List<UserSkillMiddle> selectByExample(UserSkillMiddleExample example);

    UserSkillMiddle selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") UserSkillMiddle record, @Param("example") UserSkillMiddleExample example);

    int updateByExample(@Param("record") UserSkillMiddle record, @Param("example") UserSkillMiddleExample example);

    int updateByPrimaryKeySelective(UserSkillMiddle record);

    int updateByPrimaryKey(UserSkillMiddle record);
}
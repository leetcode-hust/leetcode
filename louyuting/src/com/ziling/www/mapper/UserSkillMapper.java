package com.ziling.www.mapper;

import com.ziling.www.po.UserSkill;
import com.ziling.www.po.UserSkillExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserSkillMapper {
    int countByExample(UserSkillExample example);

    int deleteByExample(UserSkillExample example);

    int deleteByPrimaryKey(String skillId);

    int insert(UserSkill record);

    int insertSelective(UserSkill record);

    List<UserSkill> selectByExample(UserSkillExample example);

    UserSkill selectByPrimaryKey(String skillId);

    int updateByExampleSelective(@Param("record") UserSkill record, @Param("example") UserSkillExample example);

    int updateByExample(@Param("record") UserSkill record, @Param("example") UserSkillExample example);

    int updateByPrimaryKeySelective(UserSkill record);

    int updateByPrimaryKey(UserSkill record);
}
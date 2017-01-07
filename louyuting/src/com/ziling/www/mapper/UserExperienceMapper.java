package com.ziling.www.mapper;

import com.ziling.www.po.UserExperience;
import com.ziling.www.po.UserExperienceExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserExperienceMapper {
    int countByExample(UserExperienceExample example);

    int deleteByExample(UserExperienceExample example);

    int deleteByPrimaryKey(String experienceId);

    int insert(UserExperience record);

    int insertSelective(UserExperience record);

    List<UserExperience> selectByExample(UserExperienceExample example);

    UserExperience selectByPrimaryKey(String experienceId);

    int updateByExampleSelective(@Param("record") UserExperience record, @Param("example") UserExperienceExample example);

    int updateByExample(@Param("record") UserExperience record, @Param("example") UserExperienceExample example);

    int updateByPrimaryKeySelective(UserExperience record);

    int updateByPrimaryKey(UserExperience record);
}
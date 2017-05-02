package com.ziling.www.mapper;

import com.ziling.www.po.ProjectQuestion;
import com.ziling.www.po.ProjectQuestionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ProjectQuestionMapper {
    int countByExample(ProjectQuestionExample example);

    int deleteByExample(ProjectQuestionExample example);

    int deleteByPrimaryKey(String questionId);

    int insert(ProjectQuestion record);

    int insertSelective(ProjectQuestion record);

    List<ProjectQuestion> selectByExample(ProjectQuestionExample example);

    ProjectQuestion selectByPrimaryKey(String questionId);

    int updateByExampleSelective(@Param("record") ProjectQuestion record, @Param("netty/example") ProjectQuestionExample example);

    int updateByExample(@Param("record") ProjectQuestion record, @Param("netty/example") ProjectQuestionExample example);

    int updateByPrimaryKeySelective(ProjectQuestion record);

    int updateByPrimaryKey(ProjectQuestion record);
}
package com.ziling.www.mapper;

import com.ziling.www.po.ProjectComment;
import com.ziling.www.po.ProjectCommentExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ProjectCommentMapper {
    int countByExample(ProjectCommentExample example);

    int deleteByExample(ProjectCommentExample example);

    int deleteByPrimaryKey(String commentId);

    int insert(ProjectComment record);

    int insertSelective(ProjectComment record);

    List<ProjectComment> selectByExample(ProjectCommentExample example);

    ProjectComment selectByPrimaryKey(String commentId);

    int updateByExampleSelective(@Param("record") ProjectComment record, @Param("example") ProjectCommentExample example);

    int updateByExample(@Param("record") ProjectComment record, @Param("example") ProjectCommentExample example);

    int updateByPrimaryKeySelective(ProjectComment record);

    int updateByPrimaryKey(ProjectComment record);
}
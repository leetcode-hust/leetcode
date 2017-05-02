package com.ziling.www.mapper;

import com.ziling.www.po.Project;
import com.ziling.www.po.ProjectExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ProjectMapper {
    int countByExample(ProjectExample example);

    int deleteByExample(ProjectExample example);

    int deleteByPrimaryKey(String projectId);

    int insert(Project record);

    int insertSelective(Project record);

    List<Project> selectByExample(ProjectExample example);

    Project selectByPrimaryKey(String projectId);

    int updateByExampleSelective(@Param("record") Project record, @Param("netty/example") ProjectExample example);

    int updateByExample(@Param("record") Project record, @Param("netty/example") ProjectExample example);

    int updateByPrimaryKeySelective(Project record);

    int updateByPrimaryKey(Project record);
}
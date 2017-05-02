package com.ziling.www.mapper;

import com.ziling.www.po.ProjectProgress;
import com.ziling.www.po.ProjectProgressExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ProjectProgressMapper {
    int countByExample(ProjectProgressExample example);

    int deleteByExample(ProjectProgressExample example);

    int deleteByPrimaryKey(String progressId);

    int insert(ProjectProgress record);

    int insertSelective(ProjectProgress record);

    List<ProjectProgress> selectByExample(ProjectProgressExample example);

    ProjectProgress selectByPrimaryKey(String progressId);

    int updateByExampleSelective(@Param("record") ProjectProgress record, @Param("netty/example") ProjectProgressExample example);

    int updateByExample(@Param("record") ProjectProgress record, @Param("netty/example") ProjectProgressExample example);

    int updateByPrimaryKeySelective(ProjectProgress record);

    int updateByPrimaryKey(ProjectProgress record);
}
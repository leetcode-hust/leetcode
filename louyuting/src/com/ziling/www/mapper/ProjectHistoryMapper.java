package com.ziling.www.mapper;

import com.ziling.www.po.ProjectHistory;
import com.ziling.www.po.ProjectHistoryExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ProjectHistoryMapper {
    int countByExample(ProjectHistoryExample example);

    int deleteByExample(ProjectHistoryExample example);

    int deleteByPrimaryKey(String id);

    int insert(ProjectHistory record);

    int insertSelective(ProjectHistory record);

    List<ProjectHistory> selectByExample(ProjectHistoryExample example);

    ProjectHistory selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") ProjectHistory record, @Param("example") ProjectHistoryExample example);

    int updateByExample(@Param("record") ProjectHistory record, @Param("example") ProjectHistoryExample example);

    int updateByPrimaryKeySelective(ProjectHistory record);

    int updateByPrimaryKey(ProjectHistory record);
}
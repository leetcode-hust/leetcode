package com.ziling.www.mapper;

import com.ziling.www.po.ProjectCodeSource;
import com.ziling.www.po.ProjectCodeSourceExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ProjectCodeSourceMapper {
    int countByExample(ProjectCodeSourceExample example);

    int deleteByExample(ProjectCodeSourceExample example);

    int deleteByPrimaryKey(String codeId);

    int insert(ProjectCodeSource record);

    int insertSelective(ProjectCodeSource record);

    List<ProjectCodeSource> selectByExample(ProjectCodeSourceExample example);

    ProjectCodeSource selectByPrimaryKey(String codeId);

    int updateByExampleSelective(@Param("record") ProjectCodeSource record, @Param("netty/example") ProjectCodeSourceExample example);

    int updateByExample(@Param("record") ProjectCodeSource record, @Param("netty/example") ProjectCodeSourceExample example);

    int updateByPrimaryKeySelective(ProjectCodeSource record);

    int updateByPrimaryKey(ProjectCodeSource record);
}
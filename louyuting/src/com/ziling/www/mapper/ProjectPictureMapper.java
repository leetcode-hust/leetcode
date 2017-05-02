package com.ziling.www.mapper;

import com.ziling.www.po.ProjectPicture;
import com.ziling.www.po.ProjectPictureExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ProjectPictureMapper {
    int countByExample(ProjectPictureExample example);

    int deleteByExample(ProjectPictureExample example);

    int deleteByPrimaryKey(String pictureId);

    int insert(ProjectPicture record);

    int insertSelective(ProjectPicture record);

    List<ProjectPicture> selectByExample(ProjectPictureExample example);

    ProjectPicture selectByPrimaryKey(String pictureId);

    int updateByExampleSelective(@Param("record") ProjectPicture record, @Param("netty/example") ProjectPictureExample example);

    int updateByExample(@Param("record") ProjectPicture record, @Param("netty/example") ProjectPictureExample example);

    int updateByPrimaryKeySelective(ProjectPicture record);

    int updateByPrimaryKey(ProjectPicture record);
}
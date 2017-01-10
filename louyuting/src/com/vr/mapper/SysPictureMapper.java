package com.vr.mapper;

import com.vr.po.SysPicture;
import com.vr.po.SysPictureExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysPictureMapper {
    int countByExample(SysPictureExample example);

    int deleteByExample(SysPictureExample example);

    int deleteByPrimaryKey(String picId);

    int insert(SysPicture record);

    int insertSelective(SysPicture record);

    List<SysPicture> selectByExample(SysPictureExample example);

    SysPicture selectByPrimaryKey(String picId);

    int updateByExampleSelective(@Param("record") SysPicture record, @Param("example") SysPictureExample example);

    int updateByExample(@Param("record") SysPicture record, @Param("example") SysPictureExample example);

    int updateByPrimaryKeySelective(SysPicture record);

    int updateByPrimaryKey(SysPicture record);
}
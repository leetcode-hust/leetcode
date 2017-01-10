package com.vr.mapper;

import com.vr.po.SysActivity;
import com.vr.po.SysActivityExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysActivityMapper {
    int countByExample(SysActivityExample example);

    int deleteByExample(SysActivityExample example);

    int deleteByPrimaryKey(String actId);

    int insert(SysActivity record);

    int insertSelective(SysActivity record);

    List<SysActivity> selectByExample(SysActivityExample example);

    SysActivity selectByPrimaryKey(String actId);

    int updateByExampleSelective(@Param("record") SysActivity record, @Param("example") SysActivityExample example);

    int updateByExample(@Param("record") SysActivity record, @Param("example") SysActivityExample example);

    int updateByPrimaryKeySelective(SysActivity record);

    int updateByPrimaryKey(SysActivity record);
}
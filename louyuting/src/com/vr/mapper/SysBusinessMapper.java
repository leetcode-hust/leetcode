package com.vr.mapper;

import com.vr.po.SysBusiness;
import com.vr.po.SysBusinessExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysBusinessMapper {
    int countByExample(SysBusinessExample example);

    int deleteByExample(SysBusinessExample example);

    int deleteByPrimaryKey(String busId);

    int insert(SysBusiness record);

    int insertSelective(SysBusiness record);

    List<SysBusiness> selectByExample(SysBusinessExample example);

    SysBusiness selectByPrimaryKey(String busId);

    int updateByExampleSelective(@Param("record") SysBusiness record, @Param("netty/example") SysBusinessExample example);

    int updateByExample(@Param("record") SysBusiness record, @Param("netty/example") SysBusinessExample example);

    int updateByPrimaryKeySelective(SysBusiness record);

    int updateByPrimaryKey(SysBusiness record);
}
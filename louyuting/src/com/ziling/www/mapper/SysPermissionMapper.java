package com.ziling.www.mapper;

import com.ziling.www.po.SysPermission;
import com.ziling.www.po.SysPermissionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysPermissionMapper {
    int countByExample(SysPermissionExample example);

    int deleteByExample(SysPermissionExample example);

    int deleteByPrimaryKey(String permissionId);

    int insert(SysPermission record);

    int insertSelective(SysPermission record);

    List<SysPermission> selectByExample(SysPermissionExample example);

    SysPermission selectByPrimaryKey(String permissionId);

    int updateByExampleSelective(@Param("record") SysPermission record, @Param("netty/example") SysPermissionExample example);

    int updateByExample(@Param("record") SysPermission record, @Param("netty/example") SysPermissionExample example);

    int updateByPrimaryKeySelective(SysPermission record);

    int updateByPrimaryKey(SysPermission record);
}
package com.vr.mapper;

import com.vr.po.SysCollection;
import com.vr.po.SysCollectionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysCollectionMapper {
    int countByExample(SysCollectionExample example);

    int deleteByExample(SysCollectionExample example);

    int deleteByPrimaryKey(String collectionId);

    int insert(SysCollection record);

    int insertSelective(SysCollection record);

    List<SysCollection> selectByExample(SysCollectionExample example);

    SysCollection selectByPrimaryKey(String collectionId);

    int updateByExampleSelective(@Param("record") SysCollection record, @Param("netty/example") SysCollectionExample example);

    int updateByExample(@Param("record") SysCollection record, @Param("netty/example") SysCollectionExample example);

    int updateByPrimaryKeySelective(SysCollection record);

    int updateByPrimaryKey(SysCollection record);
}
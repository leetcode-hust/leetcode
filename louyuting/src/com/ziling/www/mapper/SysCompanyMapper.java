package com.ziling.www.mapper;

import com.ziling.www.po.SysCompany;
import com.ziling.www.po.SysCompanyExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysCompanyMapper {
    int countByExample(SysCompanyExample example);

    int deleteByExample(SysCompanyExample example);

    int deleteByPrimaryKey(String companyId);

    int insert(SysCompany record);

    int insertSelective(SysCompany record);

    List<SysCompany> selectByExample(SysCompanyExample example);

    SysCompany selectByPrimaryKey(String companyId);

    int updateByExampleSelective(@Param("record") SysCompany record, @Param("netty/example") SysCompanyExample example);

    int updateByExample(@Param("record") SysCompany record, @Param("netty/example") SysCompanyExample example);

    int updateByPrimaryKeySelective(SysCompany record);

    int updateByPrimaryKey(SysCompany record);
}
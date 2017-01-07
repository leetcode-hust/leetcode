package com.ziling.www.mapper;

import com.ziling.www.po.UserInvoice;
import com.ziling.www.po.UserInvoiceExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserInvoiceMapper {
    int countByExample(UserInvoiceExample example);

    int deleteByExample(UserInvoiceExample example);

    int deleteByPrimaryKey(String invoicelId);

    int insert(UserInvoice record);

    int insertSelective(UserInvoice record);

    List<UserInvoice> selectByExample(UserInvoiceExample example);

    UserInvoice selectByPrimaryKey(String invoicelId);

    int updateByExampleSelective(@Param("record") UserInvoice record, @Param("example") UserInvoiceExample example);

    int updateByExample(@Param("record") UserInvoice record, @Param("example") UserInvoiceExample example);

    int updateByPrimaryKeySelective(UserInvoice record);

    int updateByPrimaryKey(UserInvoice record);
}
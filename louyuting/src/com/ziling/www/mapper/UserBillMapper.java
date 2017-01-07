package com.ziling.www.mapper;

import com.ziling.www.po.UserBill;
import com.ziling.www.po.UserBillExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserBillMapper {
    int countByExample(UserBillExample example);

    int deleteByExample(UserBillExample example);

    int deleteByPrimaryKey(String billId);

    int insert(UserBill record);

    int insertSelective(UserBill record);

    List<UserBill> selectByExample(UserBillExample example);

    UserBill selectByPrimaryKey(String billId);

    int updateByExampleSelective(@Param("record") UserBill record, @Param("example") UserBillExample example);

    int updateByExample(@Param("record") UserBill record, @Param("example") UserBillExample example);

    int updateByPrimaryKeySelective(UserBill record);

    int updateByPrimaryKey(UserBill record);
}
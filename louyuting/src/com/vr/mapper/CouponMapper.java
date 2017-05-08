package com.vr.mapper;

import com.vr.po.Coupon;
import com.vr.po.CouponExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CouponMapper {
    int countByExample(CouponExample example);

    int deleteByExample(CouponExample example);

    int deleteByPrimaryKey(String bonusId);

    int insert(Coupon record);

    int insertSelective(Coupon record);

    List<Coupon> selectByExample(CouponExample example);

    Coupon selectByPrimaryKey(String bonusId);

    int updateByExampleSelective(@Param("record") Coupon record, @Param("netty/example") CouponExample example);

    int updateByExample(@Param("record") Coupon record, @Param("netty/example") CouponExample example);

    int updateByPrimaryKeySelective(Coupon record);

    int updateByPrimaryKey(Coupon record);
}
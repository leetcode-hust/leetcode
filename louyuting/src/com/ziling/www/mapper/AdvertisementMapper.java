package com.ziling.www.mapper;

import com.ziling.www.po.Advertisement;
import com.ziling.www.po.AdvertisementExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AdvertisementMapper {
    int countByExample(AdvertisementExample example);

    int deleteByExample(AdvertisementExample example);

    int deleteByPrimaryKey(String adId);

    int insert(Advertisement record);

    int insertSelective(Advertisement record);

    List<Advertisement> selectByExample(AdvertisementExample example);

    Advertisement selectByPrimaryKey(String adId);

    int updateByExampleSelective(@Param("record") Advertisement record, @Param("netty/example") AdvertisementExample example);

    int updateByExample(@Param("record") Advertisement record, @Param("netty/example") AdvertisementExample example);

    int updateByPrimaryKeySelective(Advertisement record);

    int updateByPrimaryKey(Advertisement record);
}
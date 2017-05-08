package com.vr.mapper;

import com.vr.po.Bonus;
import com.vr.po.BonusExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface BonusMapper {
    int countByExample(BonusExample example);

    int deleteByExample(BonusExample example);

    int deleteByPrimaryKey(String bonusId);

    int insert(Bonus record);

    int insertSelective(Bonus record);

    List<Bonus> selectByExample(BonusExample example);

    Bonus selectByPrimaryKey(String bonusId);

    int updateByExampleSelective(@Param("record") Bonus record, @Param("netty/example") BonusExample example);

    int updateByExample(@Param("record") Bonus record, @Param("netty/example") BonusExample example);

    int updateByPrimaryKeySelective(Bonus record);

    int updateByPrimaryKey(Bonus record);
}
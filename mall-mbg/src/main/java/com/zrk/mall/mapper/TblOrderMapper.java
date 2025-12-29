package com.zrk.mall.mapper;

import com.zrk.mall.model.TblOrder;
import com.zrk.mall.model.TblOrderExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TblOrderMapper {
    long countByExample(TblOrderExample example);

    int deleteByExample(TblOrderExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TblOrder row);

    int insertSelective(TblOrder row);

    List<TblOrder> selectByExample(TblOrderExample example);

    TblOrder selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("row") TblOrder row, @Param("example") TblOrderExample example);

    int updateByExample(@Param("row") TblOrder row, @Param("example") TblOrderExample example);

    int updateByPrimaryKeySelective(TblOrder row);

    int updateByPrimaryKey(TblOrder row);
}
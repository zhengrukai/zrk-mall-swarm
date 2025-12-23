package com.zrk.mall.mapper;

import com.zrk.mall.model.SysResource;
import com.zrk.mall.model.SysResourceExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysResourceMapper {
    long countByExample(SysResourceExample example);

    int deleteByExample(SysResourceExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SysResource row);

    int insertSelective(SysResource row);

    List<SysResource> selectByExample(SysResourceExample example);

    SysResource selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("row") SysResource row, @Param("example") SysResourceExample example);

    int updateByExample(@Param("row") SysResource row, @Param("example") SysResourceExample example);

    int updateByPrimaryKeySelective(SysResource row);

    int updateByPrimaryKey(SysResource row);
}
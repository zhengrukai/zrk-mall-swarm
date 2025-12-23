package com.zrk.mall.mapper;

import com.zrk.mall.model.SysUserLoginLog;
import com.zrk.mall.model.SysUserLoginLogExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysUserLoginLogMapper {
    long countByExample(SysUserLoginLogExample example);

    int deleteByExample(SysUserLoginLogExample example);

    int deleteByPrimaryKey(Long id);

    int insert(SysUserLoginLog row);

    int insertSelective(SysUserLoginLog row);

    List<SysUserLoginLog> selectByExample(SysUserLoginLogExample example);

    SysUserLoginLog selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("row") SysUserLoginLog row, @Param("example") SysUserLoginLogExample example);

    int updateByExample(@Param("row") SysUserLoginLog row, @Param("example") SysUserLoginLogExample example);

    int updateByPrimaryKeySelective(SysUserLoginLog row);

    int updateByPrimaryKey(SysUserLoginLog row);
}
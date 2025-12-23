package com.zrk.mall.mapper;

import com.zrk.mall.model.SysUserRoleRelation;
import com.zrk.mall.model.SysUserRoleRelationExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysUserRoleRelationMapper {
    long countByExample(SysUserRoleRelationExample example);

    int deleteByExample(SysUserRoleRelationExample example);

    int deleteByPrimaryKey(Long userId);

    int insert(SysUserRoleRelation row);

    int insertSelective(SysUserRoleRelation row);

    List<SysUserRoleRelation> selectByExample(SysUserRoleRelationExample example);

    SysUserRoleRelation selectByPrimaryKey(Long userId);

    int updateByExampleSelective(@Param("row") SysUserRoleRelation row, @Param("example") SysUserRoleRelationExample example);

    int updateByExample(@Param("row") SysUserRoleRelation row, @Param("example") SysUserRoleRelationExample example);

    int updateByPrimaryKeySelective(SysUserRoleRelation row);

    int updateByPrimaryKey(SysUserRoleRelation row);
}
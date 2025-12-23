package com.zrk.mall.mapper;

import com.zrk.mall.model.SysRoleResourceRelation;
import com.zrk.mall.model.SysRoleResourceRelationExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SysRoleResourceRelationMapper {
    long countByExample(SysRoleResourceRelationExample example);

    int deleteByExample(SysRoleResourceRelationExample example);

    int deleteByPrimaryKey(@Param("roleId") Long roleId, @Param("resourceId") Long resourceId);

    int insert(SysRoleResourceRelation row);

    int insertSelective(SysRoleResourceRelation row);

    List<SysRoleResourceRelation> selectByExample(SysRoleResourceRelationExample example);

    int updateByExampleSelective(@Param("row") SysRoleResourceRelation row, @Param("example") SysRoleResourceRelationExample example);

    int updateByExample(@Param("row") SysRoleResourceRelation row, @Param("example") SysRoleResourceRelationExample example);
}
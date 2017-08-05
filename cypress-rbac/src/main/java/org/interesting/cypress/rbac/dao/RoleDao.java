package org.interesting.cypress.rbac.dao;

import org.apache.ibatis.annotations.Param;
import org.interesting.cypress.rbac.entity.Role;

import java.util.List;

/**
 * 角色操作
 * @author vv
 * @since 2017/8/5.
 */
public interface RoleDao {

    Role getRole(Long roleId);

    int addRole(Role role);

    int updateRole(Role role);

    int deleteRoles(List<Long> roleIds);

    List<Long> getMenuIds(Long roleId);

    /**
     * 给角色批量添加菜单
     * @param roleId 角色
     * @param menuIds 菜单
     * @return 添加成功个数
     */
    int addMenus(@Param("roleId") Long roleId, @Param("menuIds")List<Long> menuIds);

    /**
     * 删除此角色的部分菜单
     * @param roleId 角色
     * @param menuIds 需要删除的菜单
     * @return 删除的个数
     */
    int deleteMenus(@Param("roleId") Long roleId, @Param("menuIds")List<Long> menuIds);


}

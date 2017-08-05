package org.interesting.cypress.rbac.service;

import java.util.List;

/**
 * 角色菜单，一个角色可对应多个菜单
 * 
 * @author vv
 * @since 2017/8/5.
 */
public interface RoleMenuService {

    /**
     * 保存 角色和菜单的对应关系
     * 
     * @param roleId 角色
     * @param menuIdList 菜单
     * @return 是否保存成功
     */
    boolean save(Long roleId, List<Long> menuIdList);

    /**
     * 根据角色ID，获取菜单ID列表
     * 
     * @param roleId 角色
     * @return 菜单id列表
     */
    List<Long> queryMenuIds(Long roleId);
}

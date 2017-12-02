package org.interesting.cypress.rbac.service;

import org.interesting.cypress.rbac.entity.Menu;

import java.util.List;

/**
 * 菜单服务
 * 
 * @see Menu
 * @author vv
 * @since 2017/8/5.
 */
public interface MenuService {

    /**
     * 获取菜单
     * 
     * @param menuId 菜单Id
     * @return 菜单
     */
    Menu getMenu(Long menuId);

    /**
     * 新增或是更新菜单
     * 
     * @param menu 菜单
     * @return 是否保存成功
     */
    boolean saveMenu(Menu menu);

    /**
     * 删除菜单
     * 
     * @param menuIds 菜单id
     * @return 是否成功删除
     */
    boolean deleteMenus(List<Long> menuIds);

    /**
     * 获取子菜单
     * 
     * @param menuId 菜单id
     * @return 菜单
     */
    List<Menu> getChildren(Long menuId);

    /**
     * 获取用户所拥有的菜单
     * 
     * @param userId 用户id
     * @return 菜单
     */
    List<Menu> getUserMenus(Long userId);
}

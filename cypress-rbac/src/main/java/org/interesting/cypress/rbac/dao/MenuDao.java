package org.interesting.cypress.rbac.dao;

import org.interesting.cypress.rbac.entity.Menu;

import java.util.List;

/**
 * 菜单操作
 *
 * @author vv
 * @since 2017/8/5.
 */
public interface MenuDao {

    Menu getMenu(Long menuId);

    int addMenu(Menu menu);

    int updateMenu(Menu menu);

    int deleteMenus(List<Long> menuIds);

    List<Menu> getChildren(Long menuId);

    /**
     * 获取用户所拥有的菜单
     * @param userId 用户Id
     * @return 菜单
     */
    List<Menu> getUserMenus(Long userId);

}

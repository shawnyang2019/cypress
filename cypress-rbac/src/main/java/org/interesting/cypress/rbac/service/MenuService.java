package org.interesting.cypress.rbac.service;

import org.interesting.cypress.rbac.entity.Menu;

import java.util.List;

/**
 * 菜单服务
 * @see Menu
 * @author vv
 * @since 2017/8/5.
 */
public interface MenuService {

    Menu getMenu(Long menuId);

    boolean saveMenu(Menu menu);

    boolean deleteMenus(List<Long> menuIds);

    List<Menu> getChildren(Long menuId);

    List<Menu> getUserMenus(Long userId);
}

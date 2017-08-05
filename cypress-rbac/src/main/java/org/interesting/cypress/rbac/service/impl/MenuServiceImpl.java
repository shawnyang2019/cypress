package org.interesting.cypress.rbac.service.impl;

import org.apache.commons.collections.CollectionUtils;
import org.interesting.cypress.rbac.dao.MenuDao;
import org.interesting.cypress.rbac.entity.Menu;
import org.interesting.cypress.rbac.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

/**
 * 菜单实现类
 *
 * @author vv
 * @since 2017/8/5.
 */
public class MenuServiceImpl implements MenuService {

    @Autowired
    private MenuDao menuDao;

    @Override
    public Menu getMenu(Long menuId) {
        if (menuId == null) {
            return null;
        }
        return menuDao.getMenu(menuId);
    }

    @Override
    public boolean saveMenu(Menu menu) {
        if (menu == null) {
            return true;
        }
        if (menu.getId() == null) {
            menuDao.addMenu(menu);
        } else {
            menuDao.updateMenu(menu);
        }
        return true;
    }

    @Override
    public boolean deleteMenus(List<Long> menuIds) {
        if (CollectionUtils.isEmpty(menuIds)) {
            return true;
        }
        menuDao.deleteMenus(menuIds);
        return true;
    }

    @Override
    public List<Menu> getChildren(Long menuId) {
        if (menuId == null) {
            return new ArrayList<>();
        }
        return menuDao.getChildren(menuId);
    }

    @Override
    public List<Menu> getUserMenus(Long userId) {
        if (userId == null) {
            return new ArrayList<>();
        }
        return menuDao.getUserMenus(userId);
    }
}

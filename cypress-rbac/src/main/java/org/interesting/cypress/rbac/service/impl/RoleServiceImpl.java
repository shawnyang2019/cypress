package org.interesting.cypress.rbac.service.impl;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.ListUtils;
import org.interesting.cypress.rbac.dao.RoleDao;
import org.interesting.cypress.rbac.entity.Role;
import org.interesting.cypress.rbac.service.RoleMenuService;
import org.interesting.cypress.rbac.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * 角色管理
 *
 * @author vv
 * @since 2017/8/5.
 */
@Service
public class RoleServiceImpl implements RoleService, RoleMenuService {

    @Autowired
    private RoleDao roleDao;

    @Override
    public Role getRole(Long roleId) {
        if (roleId == null) {
            return null;
        }
        return roleDao.getRole(roleId);
    }

    @Override
    public boolean save(Role role) {
        if (role == null) {
            return true;
        }
        if (role.getId() == null) {
            roleDao.addRole(role);
        } else {
            roleDao.updateRole(role);
        }
        return true;
    }

    @Override
    public boolean deleteRoles(List<Long> roleIds) {
        roleDao.deleteRoles(roleIds);
        return true;
    }

    @Override
    public boolean save(Long roleId, List<Long> menuIdList) {
        // 获取用户已有的菜单
        List<Long> ownedMenus = roleDao.getMenuIds(roleId);
        // 找出需要删除的菜单
        List<Long> deleteMenus = ListUtils.subtract(ownedMenus, menuIdList);
        if (CollectionUtils.isNotEmpty(deleteMenus)) {
            roleDao.deleteMenus(roleId, deleteMenus);
        }
        // 找出本次新增的菜单
        List<Long> addMenu = ListUtils.subtract(menuIdList, ownedMenus);
        if (CollectionUtils.isNotEmpty(addMenu)) {
            roleDao.addMenus(roleId, addMenu);
        }
        return true;
    }

    @Override
    public List<Long> getMenuIds(Long roleId) {
        if (roleId == null) {
            return new ArrayList<>();
        }
        return roleDao.getMenuIds(roleId);
    }
}

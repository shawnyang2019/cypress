package org.interesting.cypress.rbac.service.impl;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.ListUtils;
import org.interesting.cypress.rbac.dao.UserDao;
import org.interesting.cypress.rbac.entity.User;
import org.interesting.cypress.rbac.service.UserRoleService;
import org.interesting.cypress.rbac.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * 用户服务实现
 * 
 * @author vv
 * @since 2017/7/30.
 */
@Service
public class UserServiceImpl implements UserService, UserRoleService {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserServiceImpl.class);

    /**
     * userDao
     */
    @Autowired
    private UserDao userDao;

    @Override
    public User getUser(Integer id) {
        if (id == null) {
            return null;
        }
        return userDao.getUser(id);
    }

    @Override
    public boolean saveUser(User user) {
        if (user == null) {
            return true;
        }
        if (user.getId() != null) {
            userDao.updateUser(user);
        } else {
            userDao.addUser(user);
        }
        return true;
    }

    @Override
    public boolean deleteUsers(List<Long> userIds) {
        if (CollectionUtils.isEmpty(userIds)) {
            return true;
        }
        userDao.deleteUsers(userIds);
        return true;
    }

    @Override
    public List<String> getPermissions(Long userId) {
        if (userId == null) {
            return new ArrayList<>();
        }
        return userDao.getPermissions(userId);
    }

    @Override
    public List<Long> getMenuIds(Long userId) {
        if (userId == null) {
            return new ArrayList<>();
        }
        return userDao.getMenuIds(userId);
    }

    @Override
    public List<Long> getRoleIds(Long userId) {
        if (userId == null) {
            return new ArrayList<>();
        }
        return userDao.getRoleIds(userId);
    }

    @Override
    public boolean clearRole(Long userId) {
        if (userId == null) {
            return true;
        }
        userDao.deleteAllRole(userId);
        return true;
    }

    @Override
    @Transactional
    public boolean save(Long userId, List<Long> roleIdList) {
        // 获取用户已有的角色
        List<Long> ownedRoles = userDao.getRoleIds(userId);
        // 找出被删除的角色
        List<Long> deleteRole = ListUtils.subtract(ownedRoles, roleIdList);
        if (CollectionUtils.isNotEmpty(deleteRole)) {
            userDao.deleteRoles(userId, deleteRole);
        }
        // 找出本次新增的角色
        List<Long> addRole = ListUtils.subtract(roleIdList, ownedRoles);
        if (CollectionUtils.isNotEmpty(addRole)) {
            userDao.addRoles(userId, addRole);
        }
        return true;
    }
}

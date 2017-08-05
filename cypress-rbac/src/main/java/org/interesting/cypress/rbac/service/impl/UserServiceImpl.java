package org.interesting.cypress.rbac.service.impl;

import org.interesting.cypress.rbac.entity.User;
import org.interesting.cypress.rbac.service.UserRoleService;
import org.interesting.cypress.rbac.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 用户服务实现
 * 
 * @author vv
 * @since 2017/7/30.
 */
@Service
public class UserServiceImpl implements UserService, UserRoleService {
    @Override
    public User getUser(Integer id) {
        return null;
    }

    @Override
    public boolean saveUser(User user) {
        return false;
    }

    @Override
    public boolean deleteUsers(List<Long> userIds) {
        return false;
    }

    @Override
    public List<String> getPermission(Long userId) {
        return null;
    }

    @Override
    public List<Long> getMenuIds(Long userId) {
        return null;
    }

    @Override
    public List<Long> getRoleIds(Long userId) {
        return null;
    }

    @Override
    public boolean clearRole(Long userId) {
        return false;
    }

    @Override
    public boolean save(Long userId, List<Long> roleIdList) {
        return false;
    }
}

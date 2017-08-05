package org.interesting.cypress.rbac.service;

import org.interesting.cypress.rbac.entity.Role;

import java.util.List;

/**
 * 角色控制
 * 
 * @author vv
 * @since 2017/8/5.
 */
public interface RoleService {

    Role getRole(Long roleId);

    boolean save(Role role);

    boolean deleteRoles(List<Long> roleIds);

}

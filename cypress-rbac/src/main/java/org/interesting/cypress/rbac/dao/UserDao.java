package org.interesting.cypress.rbac.dao;

import org.apache.ibatis.annotations.Param;
import org.interesting.cypress.rbac.entity.User;

import java.util.List;

public interface UserDao {

    User getUser(long id);

    int addUser(User user);

    int updateUser(User user);

    int deleteUsers(List<Long> id);

    List<String> getPermissions(Long userId);

    List<Long> getMenuIds(Long userId);

    List<Long> getRoleIds(Long userId);

    int deleteAllRole(Long userId);

    int deleteRoles(@Param("userId") Long userId, @Param("roleIds") List<Long> roleIds);

    int addRoles(@Param("userId")Long userId, @Param("roleIds") List<Long> roleIds);
}

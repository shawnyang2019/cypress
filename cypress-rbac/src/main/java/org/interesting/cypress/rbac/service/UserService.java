package org.interesting.cypress.rbac.service;

import org.interesting.cypress.rbac.entity.User;

import java.util.List;

/**
 * 用户服务
 * 
 * @author vv
 * @since 2017/7/30.
 */
public interface UserService {

    /**
     * 查询用户
     * 
     * @param userId 用户id
     * @return 用户实体
     */
    User getUser(Integer userId);

    /**
     * 保存用户
     * 
     * @param user 用户实体
     * @return 是否成功保存
     */
    boolean saveUser(User user);

    /**
     * 批量删除用户
     * 
     * @param userIds 用户id列表
     * @return 是否成功删除
     */
    boolean deleteUsers(List<Long> userIds);

    /**
     * 获取用户权限
     *
     * @param userId 用户id
     * @return 用户所拥有的所有权限
     */
    List<String> getPermissions(Long userId);

    /**
     * 查询用户的菜单
     */
    List<Long> getMenuIds(Long userId);

}

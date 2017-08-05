package org.interesting.cypress.rbac.service;

import java.util.List;

/**
 *
 * 用户和角色关系服务
 * 
 * @author vv
 * @since 2017/8/4.
 */
public interface UserRoleService {

    /**
     * 根据用户ID，获取角色ID列表
     */
    List<Long> getRoleIds(Long userId);

    /**
     * 清除此用户对应的所有角色
     * 
     * @param userId 用户
     * @return 是否成功清除
     */
    boolean clearRole(Long userId);

    /**
     * 保存角色关系映射
     * 
     * @param userId 用户
     * @param roleIdList 角色
     * @return 是否保存成功
     */
    boolean save(Long userId, List<Long> roleIdList);
}

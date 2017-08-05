/**
 *
 * Role Based Access Control
 * 
 * 用户--角色--菜单 模型。
 * 
 * 菜单代表着权限， 用户能看到用户管理下的新增按钮，即表明其拥有新增用户的权限。<br/>
 * 菜单和权限存在着一对多的关系，如，参数管理下不细分权限，只要能看到参数管理，该用户即拥有增删改查的权利
 *
 * @author vv
 * @since 2017/7/30.
 */
package org.interesting.cypress.rbac;
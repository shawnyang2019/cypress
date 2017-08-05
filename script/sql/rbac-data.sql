INSERT INTO `user` VALUES(1,'admin','123','1', 'vv@163.com', '15856789876',1,0,'2017-08-05');

INSERT INTO `role` VALUES(1,'administrator','','0', '2017-08-05');

-- 用户角色对应关系
INSERT INTO `user_role` VALUES(1,1,1);


-- 一级菜单
INSERT INTO `menu` VALUES(1,0,'系统管理','','',0,'fa fa-cog',1);
INSERT INTO `menu` VALUES(2,1,'用户管理','/rbac/user.html','',1,'fa fa-user',1);
INSERT INTO `menu` VALUES(3,1,'角色管理','/rbac/role.html','',1,'fa fa-user-secret',2);
INSERT INTO `menu` VALUES(4,1,'菜单管理','/rbac/menu.html','',1,'fa fa-th-list',3);
INSERT INTO `menu` VALUES(5,1,'参数管理','/common/param.html','common:param:create,common:param:query,common:param:save,common:param:delete',1,'fa fa-user',4);

-- 用户管理的内容
INSERT INTO `menu` VALUES(6,2,'新增','','rbac:user:create',2,'',1);
INSERT INTO `menu` VALUES(7,2,'删除','','rbac:user:delete',2,'',2);
INSERT INTO `menu` VALUES(8,2,'保存','','rbac:user:save',2,'',3);

-- 角色-菜单对应关系
INSERT INTO `role_menu` VALUES(1,1,1);
INSERT INTO `role_menu` VALUES(2,1,2);
INSERT INTO `role_menu` VALUES(3,1,3);
INSERT INTO `role_menu` VALUES(4,1,4);
INSERT INTO `role_menu` VALUES(5,1,5);
INSERT INTO `role_menu` VALUES(6,1,6);
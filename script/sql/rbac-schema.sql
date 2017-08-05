DROP DATABASE IF EXISTS `cypress`;
CREATE DATABASE `cypress`
  DEFAULT CHARACTER SET utf8
  COLLATE utf8_general_ci;
;
USE `cypress`;


-- 用户
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  id              BIGINT NOT NULL AUTO_INCREMENT,
  username        VARCHAR(100),
  password        VARCHAR(100),
  salt            VARCHAR(20),
  email           VARCHAR(100),
  mobile          VARCHAR(100),
  status          TINYINT COMMENT 'status 0:disable,1:normal',
  creator         BIGINT(20),
  createTime      DATETIME,
  CONSTRAINT pk_user PRIMARY KEY (id)
) ENGINE = InnoDB CHARSET = utf8;

CREATE UNIQUE INDEX idx_user_username
  ON `user` (username);


-- 角色
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  id BIGINT NOT NULL AUTO_INCREMENT,
  role_name VARCHAR(100),
  remark VARCHAR(100),
  creator BIGINT(20) COMMENT 'creator id',
  create_time DATETIME,
  PRIMARY KEY (id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;



-- 用户与角色对应关系
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `user_id` BIGINT,
  `role_id` BIGINT,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


-- 菜单
DROP TABLE IF EXISTS `menu`;
CREATE TABLE `menu` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `parent_id` BIGINT COMMENT 'root:0',
  `name` VARCHAR(50),
  `url` VARCHAR(200) COMMENT 'menu URL',
  `permissions` varchar(500) COMMENT 'like user:list,user:create',
  `type` INT COMMENT '0:directory 1:menu 2:button',
  `icon` VARCHAR(50),
  `order` INT,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


-- 角色与菜单对应关系
DROP TABLE IF EXISTS `role_menu`;
CREATE TABLE `role_menu` (
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `role_id` BIGINT,
  `menu_id` BIGINT,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
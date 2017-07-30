DROP DATABASE IF EXISTS `cypress`;
CREATE DATABASE `cypress`
  DEFAULT CHARACTER SET utf8
  COLLATE utf8_general_ci;
;
USE `cypress`;

DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  id              BIGINT AUTO_INCREMENT,
  organization_id BIGINT,
  username        VARCHAR(100),
  password        VARCHAR(100),
  salt            VARCHAR(100),
  role_ids        VARCHAR(100),
  locked          BOOL   DEFAULT FALSE,
  CONSTRAINT pk_user PRIMARY KEY (id)
) CHARSET = utf8 ENGINE = InnoDB;
CREATE UNIQUE INDEX idx_user_username
  ON sys_user (username);


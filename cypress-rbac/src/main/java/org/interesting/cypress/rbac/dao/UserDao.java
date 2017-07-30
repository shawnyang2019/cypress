package org.interesting.cypress.rbac.dao;

import org.apache.ibatis.annotations.Param;
import org.interesting.cypress.rbac.entity.User;

import java.util.List;

public interface UserDao {

    User getUser(long id);

    List<User> getUserByName(String name);

    List<User> getUsers(User user);

    int addUser(User user);

    int deleteUser(@Param("userId") Long id);

    int updateUser(User user);

    int addBatchUsers(List<User> users);

    int deleteBatchUsers(List<User> users);

}

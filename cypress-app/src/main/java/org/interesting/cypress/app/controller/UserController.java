package org.interesting.cypress.app.controller;

import org.interesting.cypress.rbac.entity.User;
import org.interesting.cypress.rbac.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * @author vv
 * @since 2017/7/30.
 */
@Controller
public class UserController {

    @Autowired
    private UserService userService;

    public User user(){
        return null;
    }
}
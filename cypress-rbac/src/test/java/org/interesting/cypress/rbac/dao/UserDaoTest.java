package org.interesting.cypress.rbac.dao;

import org.interesting.cypress.rbac.entity.User;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author vv
 * @since 2017/7/30.
 */
public class UserDaoTest {

    private UserDao dao;

    @Before
    public void before() {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring/applicationContext-mybatis.xml");
        dao = context.getBean(UserDao.class);
    }

    @Test
    public void getUser() throws Exception {
        User user = dao.getUser(1);
        System.out.println(user.getUsername());
    }

}
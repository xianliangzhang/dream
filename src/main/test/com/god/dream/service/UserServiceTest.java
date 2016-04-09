package com.god.dream.service;

import com.god.dream.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by Willer on 16/4/9.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:dream-context.xml"})
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @Test
    public void test() {
        User user = userService.lookupUserById(1L);
        System.out.println(user.getId() + " -" + user.getName());
    }

}

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
@ContextConfiguration(locations = {"classpath:dream-mybatis.xml"})
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @Test
    public void test() {
        User devil = userService.findDevil(1L);
        System.out.println(devil);

        User god = userService.findGod(1L);
        System.out.println(god);
    }

}

package com.god.dream.dsrouting;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by Willer on 16/4/9.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:dream-mybatis.xml"})
public class MultipleDataSourceTest {
//
//    @Autowired
//    private UserService userService;
//
//    @Test
//    public void test() {
//        User veryGoodGod = new User();
//        veryGoodGod.setName("zhangxianliang");
//        veryGoodGod.setPassword("123446");
//
//        User veryBadDevil = new User();
//        veryBadDevil.setName("LiXiaoLu");
//        veryBadDevil.setPassword("vvv");
//
//        try {
//            userService.saveTransactionFail(veryGoodGod);
//        } catch (Exception e) {
//            System.out.println(e);
//        }
//
//        userService.saveGod(veryGoodGod);
//        userService.saveDevil(veryBadDevil);
//        System.out.println("");
//    }


}

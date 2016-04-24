package com.god.dream.service;

import com.god.dream.boss.model.region.Region;
import com.god.dream.boss.service.region.RegionService;
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
    private RegionService regionService;

    @Test
    public void test() {
        Region region = regionService.find(1L);
        System.out.println();
    }
}

package com.god.dream.boss.controller.region;

import com.god.dream.boss.model.region.Region;
import com.god.dream.boss.service.region.RegionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Administrator on 2016/4/23.
 */
@Controller
@RequestMapping("/boss/region")
public class RegionController {

    @Autowired
    private RegionService regionService;

    @ResponseBody
    @RequestMapping("/{id}")
    public Region queryRegionById(@PathVariable String id) {
        try {
            if (StringUtils.isEmpty(id)) {
                throw new RuntimeException("Parameter [id] is empty!");
            }
            return regionService.find(Long.valueOf(id));
        } catch (Exception e) {
            return null;
        }
    }

}

package com.god.dream.boss.controller.region;

import com.god.dream.boss.model.region.Region;
import com.god.dream.boss.service.region.RegionService;
import com.god.dream.common.exception.StatusCode;
import com.god.dream.common.response.Response;
import org.apache.log4j.Logger;
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
@RequestMapping("/region")
public class RegionController {
    private static final Logger RUN_LOG = Logger.getLogger(RegionController.class);

    @Autowired
    private RegionService regionService;

    @ResponseBody
    @RequestMapping("/{id}")
    public Response<Region> queryRegionById(@PathVariable String id) {
        Response<Region> response = new Response<Region>();
        try {
            if (StringUtils.isEmpty(id)) {
                throw new RuntimeException("Parameter [id] is empty!");
            }
            response.setData(regionService.find(Long.valueOf(id)));
        } catch (Exception e) {
            RUN_LOG.error(e.getMessage(), e);
            response.setCode(StatusCode.STATUS_FAILURE);
        }
        return response;
    }

}

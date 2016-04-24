package com.god.dream.ksyusers.controller.user;

import com.god.dream.common.exception.StatusCode;
import com.god.dream.common.response.Response;
import com.god.dream.ksyusers.model.user.UserInfo;
import com.god.dream.ksyusers.service.user.UserInfoService;
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
@RequestMapping("/user")
public class UserInfoController {
    private static final Logger RUN_LOG = Logger.getLogger(UserInfoController.class);

    @Autowired
    private UserInfoService userInfoService;

    @ResponseBody
    @RequestMapping("/{id}")
    public Response<UserInfo> queryUserById(@PathVariable String id) {
        Response<UserInfo> response = new Response<UserInfo>();
        try {
            if (StringUtils.isEmpty(id)) {
                throw new RuntimeException("Parameter [id] cannot be empty!");
            }
            response.setData(userInfoService.find(Long.valueOf(id)));
        } catch (Exception e) {
            RUN_LOG.error(e.getMessage(), e);
            response.setCode(StatusCode.STATUS_FAILURE);
        }
        return response;
    }
}

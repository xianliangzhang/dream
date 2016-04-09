package com.god.dream.controller;

import com.god.dream.model.User;
import com.god.dream.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Willer on 16/4/4.
 */
@Controller
@RequestMapping("/test")
public class TestController {

    @Autowired
    private UserService userService;

    @ResponseBody
    @RequestMapping
    public String test() {
        User user = userService.lookupUserById(1L);
        return "OK";
    }
}

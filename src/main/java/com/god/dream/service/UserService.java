package com.god.dream.service;

import com.god.dream.dao.IUserDao;
import com.god.dream.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by Willer on 16/4/9.
 */
@Service
public class UserService {

    @Autowired
    private IUserDao userDao;

    /**
     * 根据用户ID查找用户
     * @param id 用户ID
     */
    @Transactional(readOnly = true)
    public User lookupUserById(Long id) {
        return userDao.find(id);
    }

    /**
     * 根据用户名称查找用户
     * @param name 用户名称
     */
    @Transactional(readOnly = true)
    public List<User> lookupUsersByName(String name) {
        return userDao.lookupUsersByName(name);
    }

}

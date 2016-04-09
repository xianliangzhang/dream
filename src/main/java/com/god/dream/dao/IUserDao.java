package com.god.dream.dao;

import com.god.dream.model.User;

import java.util.List;

/**
 * Created by Willer on 16/4/9.
 */
public interface IUserDao {
    public User find(Long id);
    public List<User> lookupUsersByName(String name);
}

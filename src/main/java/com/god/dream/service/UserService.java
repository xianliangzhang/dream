package com.god.dream.service;

import com.god.dream.dao.DevilDao;
import com.god.dream.dao.GodDao;
import com.god.dream.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Willer on 16/4/9.
 */
@Service
public class UserService {

    @Autowired
    private GodDao neUserDao;

    @Autowired
    private DevilDao devilDao;

    @Transactional
    public User findGod(Long id) {
        return neUserDao.find(id);
    }

    @Transactional
    public User findDevil(Long id) {
        return devilDao.find(id);
    }
}

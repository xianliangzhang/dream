package com.god.dream.ksyusers.service.user;

import com.god.dream.ksyusers.dao.user.UserInfoDao;
import com.god.dream.ksyusers.model.user.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Administrator on 2016/4/23.
 */
@Service
public class UserInfoService {

    @Autowired
    private UserInfoDao userInfoDao;

    @Transactional
    public UserInfo find(Long userId) {
        return userInfoDao.find(userId);
    }
}

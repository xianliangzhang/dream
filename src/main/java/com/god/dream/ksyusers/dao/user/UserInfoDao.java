package com.god.dream.ksyusers.dao.user;

import com.god.dream.ksyusers.model.user.UserInfo;

/**
 * Created by Administrator on 2016/4/23.
 */
public interface UserInfoDao {
    public UserInfo find(Long userId);
}

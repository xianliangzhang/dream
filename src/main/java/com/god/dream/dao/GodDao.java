package com.god.dream.dao;

import com.god.dream.common.dsrouting.DataSourceKey;
import com.god.dream.common.dsrouting.TargetDataSource;
import com.god.dream.model.User;

import java.lang.annotation.Target;

/**
 * Created by Willer on 16/4/9.
 */
@TargetDataSource(DataSourceKey.god)
public interface GodDao {
    public User find(Long id);
    public void save(User user);
}

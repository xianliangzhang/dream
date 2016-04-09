package com.god.dream.dao;

import com.god.dream.common.dsrouting.DataSourceKey;
import com.god.dream.common.dsrouting.TargetDataSource;
import com.god.dream.model.User;

/**
 * Created by Willer on 16/4/9.
 */
@TargetDataSource(DataSourceKey.DATASOURCE_DEVIL)
public interface DevilDao {
    public User find(Long id);
    public void save(User user);

}

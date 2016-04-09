package com.god.dream.common.dsrouting;

/**
 * Created by Willer on 16/4/9.
 */
public enum DataSourceKey {
    DATASOURCE_GOD("god"), DATASOURCE_DEVIL("devil");

    private String key;

    DataSourceKey(String key) {
        this.key = key;
    }

    public String toString() {
        return this.key;
    }
}

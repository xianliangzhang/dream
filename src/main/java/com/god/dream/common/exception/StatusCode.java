package com.god.dream.common.exception;

import org.apache.log4j.Logger;

import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Properties;

/**
 * Created by Administrator on 2016/4/24.
 */
public class StatusCode {
    private static final Logger RUN_LOG = Logger.getLogger(StatusCode.class);
    private static final Properties properties = new Properties();

    public static final int STATUS_FAILURE = 0;
    public static final int STATUS_SUCCESS = 1;

    // 一次性加载所有配置文件中的信息
    static {
        try (Reader reader = new InputStreamReader(StatusCode.class.getResourceAsStream("status.properties"), "UTF-8")) {
            properties.load(reader);
        } catch (Exception e) {
            RUN_LOG.error(e.getMessage(), e);
        }
    }

    // 禁止实例化该类
    private StatusCode() {
        throw new IllegalAccessError("StatusCode Cannot be Instanced!");
    }

    // 获取错误码在配置文件中对应的错误提示信息
    public static String message(int code) {
        return properties.getProperty("status.".concat(String.valueOf(code)));
    }
}

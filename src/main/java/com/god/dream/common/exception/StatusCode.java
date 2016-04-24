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

    static {
        try (Reader reader = new InputStreamReader(StatusCode.class.getResourceAsStream("status.properties"), "UTF-8")) {
            properties.load(reader);
        } catch (Exception e) {
            RUN_LOG.error(e.getMessage(), e);
        }
    }

    private StatusCode() {
        throw new IllegalAccessError("StatusCode Cannot be Instanced!");
    }

    public static String message(int code) {
        return properties.getProperty("status.".concat(String.valueOf(code)));
    }
}

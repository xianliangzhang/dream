package com.god.dream.common.dsrouting;

import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.lang.annotation.Annotation;
import java.lang.annotation.Target;
import java.lang.reflect.Method;

/**
 * Created by Willer on 16/4/9.
 */
@Aspect
@Component
public class MultipleDataSourceAspectAdvice {
    private static final Logger RUN_LOG = Logger.getLogger(MultipleDataSourceAspectAdvice.class);

    @Before("execution(* com.god.dream.dao.*.*(..))")
    public void before(JoinPoint point) {
        Annotation annotation = point.getSignature().getDeclaringType().getAnnotation(TargetDataSource.class);
        if (null != annotation && ((TargetDataSource) annotation).value() != null) {
            MultipleDataSource.setDataSourceKey(((TargetDataSource) annotation).value().toString());
        } else {
            MultipleDataSource.setDataSourceKey(DataSourceKey.DATASOURCE_GOD.toString());
        }
    }
}

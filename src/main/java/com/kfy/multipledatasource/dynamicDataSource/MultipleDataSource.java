package com.kfy.multipledatasource.dynamicDataSource;

import java.lang.annotation.*;


/**
 * 	设置拦截数据源的注解，可以设置在具体的类上，或者在具体的方法上
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MultipleDataSource {
    /**
     * 切换数据源名称
     */
    DataSourceType value() default DataSourceType.WRITE;
}

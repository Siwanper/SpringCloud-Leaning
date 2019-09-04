package com.swp.cloud.sysadmin.organization.config;

import com.baomidou.mybatisplus.core.injector.ISqlInjector;
import com.baomidou.mybatisplus.extension.injector.LogicSqlInjector;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * 描述:
 *
 * @outhor ios
 * @create 2019-09-04 12:04 PM
 */
@EnableTransactionManagement
@Configuration
@ComponentScan(basePackageClasses = com.swp.cloud.common.web.interceptor.AuditInterceptor.class)
public class MybatisConfig  {

    /**
     * 初始化Mybatis审计字段自动赋值的interceptor
     * @return
     */
    @Bean
    public ISqlInjector sqlInjector(){
        return new LogicSqlInjector();
    }

    /**
     * 分页插件
     * @return
     */
    @Bean
    public PaginationInterceptor paginationInterceptor(){
        return new PaginationInterceptor();
    }

}

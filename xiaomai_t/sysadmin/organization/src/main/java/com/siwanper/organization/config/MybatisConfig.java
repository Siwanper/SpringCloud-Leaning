package com.siwanper.organization.config;

import com.baomidou.mybatisplus.core.injector.ISqlInjector;
import com.baomidou.mybatisplus.extension.injector.LogicSqlInjector;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * 描述:
 *
 * @outhor ios
 * @create 2020-04-10 11:12 AM
 */
@Configuration
@EnableTransactionManagement
public class MybatisConfig {

    /**
     * 逻辑删除
     * @return
     */
    @Bean
    public ISqlInjector logicSqlInjector(){
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

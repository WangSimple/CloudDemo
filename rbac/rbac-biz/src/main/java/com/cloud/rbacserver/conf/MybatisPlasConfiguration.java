package com.cloud.rbacserver.conf;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.extension.plugins.PerformanceInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.Properties;

@EnableTransactionManagement
@Configuration
@MapperScan("com.cloud.rbacserver.mapper")
public class MybatisPlasConfiguration {

    /**
     * @Description 分页拦截器
     * @param
     * @return com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor
     * @author xpWang
     * @date 2020/6/18 16:13
     */
    @Bean
    public PaginationInterceptor getPaginationInterceptor(){
        return new PaginationInterceptor();
    }

    /**
     * @Description 性能分析器，格式化SQL语句
     * @param
     * @return com.baomidou.mybatisplus.extension.plugins.PerformanceInterceptor
     * @author xpWang
     * @date 2020/6/18 16:17
     */
    @Bean
    public PerformanceInterceptor getPerformanceInterceptor(){
        PerformanceInterceptor performanceInterceptor = new PerformanceInterceptor();
        Properties properties=new Properties();
        properties.setProperty("format","true");
        performanceInterceptor.setProperties(properties);
        return performanceInterceptor;
    }
}

package org.simple.rbac.server.conf;

import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import com.baomidou.mybatisplus.extension.plugins.PerformanceInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.transaction.PlatformTransactionManager;


//开启事务管理，springboot项目无需添加该注解@EnableTransactionManagement
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
    @Profile({"dev","test"})// 设置 dev test 环境开启
    public PerformanceInterceptor getPerformanceInterceptor(){
        PerformanceInterceptor performanceInterceptor = new PerformanceInterceptor();
        performanceInterceptor.setFormat(true);
        performanceInterceptor.setMaxTime(10000);//ms，超过此处设置的ms则sql不执行
        return performanceInterceptor;
    }

    /**
     * @Description 输出事务管理
     * @param platformTransactionManager
     * @return java.lang.Object
     * @author xpWang
     * @date 2020/6/21 20:24
     */
    @Bean
    public Object testBean(PlatformTransactionManager platformTransactionManager){
        System.out.println(">>>>>>>>>>" + platformTransactionManager.getClass().getName());
        return new Object();
    }
}

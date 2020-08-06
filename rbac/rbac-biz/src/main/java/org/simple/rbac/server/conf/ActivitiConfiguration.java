package org.simple.rbac.server.conf;

import org.activiti.spring.SpringAsyncExecutor;
import org.activiti.spring.SpringProcessEngineConfiguration;
import org.activiti.spring.boot.AbstractProcessEngineAutoConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;

import javax.sql.DataSource;
import java.io.IOException;

@Configuration
public class ActivitiConfiguration extends AbstractProcessEngineAutoConfiguration{

    @Autowired
    private DataSource dataSource;

    @Bean
    public SpringProcessEngineConfiguration springProcessEngineConfiguration(PlatformTransactionManager platformTransactionManager
        , SpringAsyncExecutor springAsyncExecutor,DataSource dataSource) throws IOException {
        return baseSpringProcessEngineConfiguration(dataSource,platformTransactionManager,springAsyncExecutor);
    }

}
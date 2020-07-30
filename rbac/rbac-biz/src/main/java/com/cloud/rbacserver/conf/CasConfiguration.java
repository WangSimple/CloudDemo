package com.cloud.rbacserver.conf;

import net.unicon.cas.client.configuration.CasClientConfigurerAdapter;
import net.unicon.cas.client.configuration.EnableCasClient;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Configuration;

@Configuration
//@EnableCasClient 开发的时候先把cas关了，省的开一堆东西
public class CasConfiguration extends CasClientConfigurerAdapter{

    @Override
    public void configureAuthenticationFilter(FilterRegistrationBean authenticationFilter){
        super.configureAuthenticationFilter(authenticationFilter);
        authenticationFilter.getInitParameters().put("authenticationRedirectStrategyClass","com.patterncat.CustomAuthRedirectStrategy");
    }
}

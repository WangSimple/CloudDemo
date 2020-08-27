package org.simple.zuul.config;

import org.simple.zuul.filter.AccessFiter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FilterConfig {
    @Bean
    public AccessFiter accessFiter(){
        return new AccessFiter();
    }
}

package com.cloud.rbacserver.conf;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

/**
 * 开启注解后，spring会创建一个拦截器，来实现session共享。
 */
@Configuration
@EnableRedisHttpSession(maxInactiveIntervalInSeconds = 1800)//参数为最大存活时间，设置了一个月，默认1800，30min
public class RedisConfig {
    @Bean
    public JedisConnectionFactory getFectory(){
        return new JedisConnectionFactory();
    }
}

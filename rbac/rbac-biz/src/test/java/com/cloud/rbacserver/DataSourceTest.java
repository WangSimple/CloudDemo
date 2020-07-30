package com.cloud.rbacserver;


import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.env.Environment;

import javax.sql.DataSource;
import java.sql.SQLException;
//@RunWith(SpringRunner.class)
@SpringBootTest(classes = RbacBizApplication.class)
public class DataSourceTest {
    @Autowired
    DataSource dataSource;
    @Value("${spring.profiles.include}")
    String include;
    @Value("${spring.datasource.url}")
    String dataSourceUrl;
    @Autowired
    Environment env;
    @Test
    void contextLoad(){
        try {
            System.out.println(include);
            System.out.println(dataSourceUrl);
            dataSource.getConnection();
            System.out.println(env.getProperty("spring.profiles.include"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

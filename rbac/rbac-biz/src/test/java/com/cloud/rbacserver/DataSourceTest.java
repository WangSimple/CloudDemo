package com.cloud.rbacserver;


import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

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
    @Test
    void contextLoad(){
        try {
            System.out.println(include);
            System.out.println(dataSourceUrl);
            dataSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

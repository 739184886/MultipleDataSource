package com.kfy.multipledatasource;

import com.alibaba.druid.pool.DruidDataSource;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;


@SpringBootTest
class MultipleDataSourceApplicationTests {
    @Autowired
    DataSource dataSource;

    @Test
    void contextLoads() throws SQLException {
//        外部数据链接池要有这个转换
        DruidDataSource druidDataSourceSource = (DruidDataSource)dataSource;
        System.out.println("=========="+druidDataSourceSource.getClass());
        Connection connection = druidDataSourceSource.getConnection();
        System.out.println("initialsize: " + druidDataSourceSource.getInitialSize());
        System.out.println("initialsize: " + druidDataSourceSource.getMaxActive());
        connection.close();
    }
    @Test
    void testEncoder(){

        BCryptPasswordEncoder bc = new BCryptPasswordEncoder();
        String encode = bc.encode("12345");
        String encode1 = bc.encode("12345");
        System.out.println(encode);
        System.out.println(encode1);
        boolean matches =bc.matches("12345",encode);
        boolean matches1 =bc.matches("12345",encode1);
        System.out.println(matches);
        System.out.println(matches1);

    }

}

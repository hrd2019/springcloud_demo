package com.zfec.demoservicee.config;

import java.sql.SQLException;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import com.alibaba.druid.pool.DruidDataSource;

//@ComponentScan
//@Configuration
//@EnableTransactionManagement
public class DBConfig {
	@Bean(name = "testdbSource")
	@ConfigurationProperties(prefix = "zfec.testdb.datasource")
	public DataSource dataSource() throws SQLException {
		DruidDataSource datasource = new DruidDataSource();

		return datasource;
	}
}

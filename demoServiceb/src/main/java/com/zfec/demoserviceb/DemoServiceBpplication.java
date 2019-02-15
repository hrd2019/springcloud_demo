package com.zfec.demoserviceb;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Import;

import com.codingapi.txlcn.client.config.EnableDistributedTransaction;
import com.zfec.common.db.config.DBConfig;
import com.zfec.common.db.config.MybatisConfig;

@EnableDistributedTransaction
@Import({DBConfig.class, MybatisConfig.class})
@SpringBootApplication
//@ServletComponentScan(value="com.zfec.common.filter")
//@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class})
@EnableEurekaClient
//@MapperScan(basePackages = {"com.zfec.common.dto.service1DTO"})
public class DemoServiceBpplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoServiceBpplication.class, args);
	}

}


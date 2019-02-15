package com.dnote.demoservicea;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import com.codingapi.txlcn.client.config.EnableDistributedTransaction;
import com.zfec.common.db.config.DBConfig;
import com.zfec.common.db.config.MybatisConfig;

@EnableDistributedTransaction
@SpringBootApplication
@Import({DBConfig.class, MybatisConfig.class})
//@ServletComponentScan(value="com.zfec.common.filter")
//@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class})
@EnableEurekaClient
//@MapperScan(basePackages = {"com.zfec.common.dto.service1DTO"})
public class DemoServiceaApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoServiceaApplication.class, args);

	}

}


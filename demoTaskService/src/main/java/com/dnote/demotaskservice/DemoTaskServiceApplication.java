package com.dnote.demotaskservice;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.task.configuration.EnableTask;
import org.springframework.context.annotation.Import;
import org.springframework.scheduling.annotation.EnableScheduling;

import com.codingapi.txlcn.client.config.EnableDistributedTransaction;

@EnableDistributedTransaction
@SpringBootApplication
//@ServletComponentScan(value="com.zfec.common.filter")
//@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class})
@EnableEurekaClient
@EnableScheduling
@EnableFeignClients
public class DemoTaskServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoTaskServiceApplication.class, args);
	}
}


package com.dnote.demoservicec;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

import com.codingapi.txlcn.client.config.EnableDistributedTransaction;

@EnableDistributedTransaction
@SpringBootApplication
//@ServletComponentScan(value="com.zfec.common.filter")
//@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class})
@EnableEurekaClient
@EnableFeignClients
public class DemoServiceCpplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoServiceCpplication.class, args);
	}

}


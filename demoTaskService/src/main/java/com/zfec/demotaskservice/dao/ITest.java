package com.zfec.demotaskservice.dao;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.zfec.common.dto.service1DTO.User;
import com.zfec.common.filter.FeignConfiguration;
import com.zfec.common.interceptor.FeignBasicAuthRequestInterceptor;

@FeignClient(name="demoServiceD",configuration=FeignBasicAuthRequestInterceptor.class)
//@FeignClient(name="demoServiceD")
public interface ITest {
	@RequestMapping("/query")
	public User query(@RequestParam("name") String name);
}

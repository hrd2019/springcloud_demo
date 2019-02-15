package com.zfec.demoservicec.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

//import com.zfec.common.dto.service1DTO.TestABC;

@FeignClient("demoServiceE")
public interface ITestE {
    @RequestMapping("/adda")
    void insert2(@RequestParam("a") String a,@RequestParam("b") String b);
}

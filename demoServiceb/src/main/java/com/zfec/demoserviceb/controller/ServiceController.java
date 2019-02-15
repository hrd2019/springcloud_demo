package com.zfec.demoserviceb.controller;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.codingapi.txlcn.commons.annotation.LcnTransaction;
import com.zfec.common.dto.service1DTO.TestABC;
import com.zfec.demoserviceb.dao.ITestDAO;

//import com.codingapi.txlcn.commons.annotation.LcnTransaction;
//import com.zfec.common.dto.service1DTO.TestABC;


@RestController
public class ServiceController {
	@Autowired
	ITestDAO testDAO;
	
	@RequestMapping("/xx")
	public String addUser(@RequestParam("a") String a, @RequestParam("b") String b) {
		TestABC user = new TestABC();
		user.setA(a);
		user.setB(b);
		testDAO.insert(user);
		
		return "xxx";
	}
	
	@LcnTransaction
    @Transactional
	@RequestMapping("/add")
	public String addUser2(@RequestParam("a") String a,@RequestParam("b") String b) {
    	testDAO.insert2(a,b);
    	return (a + b);
	}
}

package com.dnote.demoserviced.controller;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.codingapi.txlcn.commons.annotation.LcnTransaction;
import com.dnote.demoserviced.dao.IQueryAccount;
import com.dnote.demoserviced.dao.ITestDAO;
import com.zfec.common.dto.service1DTO.TestABC;
import com.zfec.common.dto.service1DTO.User;

//import com.codingapi.txlcn.commons.annotation.LcnTransaction;
//import com.zfec.common.dto.service1DTO.TestABC;


@RestController
public class ServiceController {
	@Autowired
	ITestDAO testDAO;
	
	@Autowired
	IQueryAccount queryAccount;
	
	@LcnTransaction
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
	
	@RequestMapping("/sel")
	public String sel(@RequestParam("a") String a) {
		String  test = testDAO.sel(a);
    	return test;
	}
	
	@RequestMapping("/query")
	public User query(@RequestParam("name") String name) {
		return queryAccount.getUserByName(name);
	}
}

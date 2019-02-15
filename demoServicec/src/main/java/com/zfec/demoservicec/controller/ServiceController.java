package com.zfec.demoservicec.controller;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.codingapi.txlcn.commons.annotation.LcnTransaction;
import com.zfec.demoservicec.dao.ITestA;
import com.zfec.demoservicec.dao.ITestB;
import com.zfec.demoservicec.dao.ITestD;
import com.zfec.demoservicec.dao.ITestE;

//import com.codingapi.txlcn.commons.annotation.LcnTransaction;
//import com.zfec.common.dto.service1DTO.TestABC;


@RestController
public class ServiceController {
	@Autowired
	ITestA testA;
	
	@Autowired
	ITestB testB;
	
	@Autowired
	ITestD testD;
	
	@Autowired
	ITestE testE;
	
	@LcnTransaction
	@RequestMapping("/adda")
	public void adda() throws Exception{
			testA.insert2("数据a", "数据a");
			testE.insert2("数据e", "数据e");
			testB.insert2("数据b", "数据超出字段设置了");
	}
	
	@LcnTransaction
    @Transactional
	@RequestMapping("/addb")
	public String addb()  throws Exception{
		testA.insert2("数据a", "数据a");
		testB.insert2("数据b", "数据b");
		testE.insert2("数据e", "数据e");
		return "good";
	}
	
	@LcnTransaction
    @Transactional
	@RequestMapping("/addc")
	public String addc()  throws Exception{
		testA.insert2("数据a", "数据a");
		testB.insert2("数据b", "数据b");
		testD.insert2("数据c", "数据c");
		testE.insert2("数据e", "数据e");
		return "good";
	}
	
	@LcnTransaction
    @Transactional
	@RequestMapping("/addd")
	public void addd() {
		try {
		testA.insert2("数据a", "数据a");
		testB.insert2("数据b", "数据b");
		testD.insert2("数据c", "数据c");
		testE.insert2("数据e", "数据e");
		testE.insert2("数据c", "数据超出字段设置了");
		}catch(Exception e) {
			throw e;
		}
	}
	
	@LcnTransaction
    @Transactional
	@RequestMapping("/adde")
	public void adde() {
		try {
		testA.insert2("数据a", "数据a");
		testB.insert2("数据b", "数据b");
		testD.insert2("数据c", "数据超出字段设置了");
		testE.insert2("数据e", "数据e");
		}catch(Exception e) {
			throw e;
		}
	}
	
	@RequestMapping("/query")
	public String query()  throws Exception{
		testA.insert2("数据a", "数据a");
		testB.insert2("数据b", "数据b");
		testD.insert2("数据c", "数据超出字段设置了");
		
		return "good";
	}
}

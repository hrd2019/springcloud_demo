package com.zfec.demotaskservice.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.zfec.demotaskservice.dao.ITest;

@Component
public class Controller {
	private static final Logger logger = LoggerFactory.getLogger(Controller.class);
	
	@Autowired
	ITest test;
	/**
	 * 每隔10秒执行, 单位：ms。
	 */
	@Scheduled(fixedRate = 10000)
	public void testFixRate2() {
		logger.info(
				"--------------------------------------------------------testFixRate2---{}------------------------------------------------------------", test.query("wkf").toString());
	}

	@Scheduled(cron = "0 0 1 * * ?") // 每天凌晨1点执行
	public void testFixRate3() {
		logger.info(
				"------------------------------------------------凌晨1点---------------------------------------------------------------");
	}
}

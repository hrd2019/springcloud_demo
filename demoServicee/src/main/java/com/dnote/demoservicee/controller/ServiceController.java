package com.dnote.demoservicee.controller;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.codingapi.txlcn.commons.annotation.LcnTransaction;
//import com.zfec.common.db.aspect.cutpoint.RedisCacheAble;
import com.dnote.common.dto.service1DTO.TestABC;
import com.dnote.common.dto.service1DTO.User;
import com.dnote.demoservicee.dao.ITestDAO;

import redis.clients.jedis.JedisCluster;
import com.alibaba.fastjson.JSON;

//import com.codingapi.txlcn.commons.annotation.LcnTransaction;
//import com.zfec.common.dto.service1DTO.TestABC;

@RestController
public class ServiceController {
	private static final Logger logger = LoggerFactory.getLogger(ServiceController.class);
	
	@Autowired
	ITestDAO testDAO;

	@Autowired
	JedisCluster jedisCluster;

	@Autowired
	RedisTemplate<String, Object> redisTemplate;

	@LcnTransaction
	@RequestMapping("/addb")
	public String addb(@RequestParam("a") String a, @RequestParam("b") String b) {
		TestABC user = new TestABC();
		user.setA(a);
		user.setB(b);
		testDAO.insert(user);

		return (a + b);
	}

	@LcnTransaction
	@Transactional
	@RequestMapping("/adda")
	@Cacheable(value="test", key="#a")
	public String adda(@RequestParam("a") String a, @RequestParam("b") String b) {
		TestABC user = new TestABC();
		user.setA(a);
		user.setB(b);
		
		TestABC user1 = new TestABC();
		user1.setA("1" +a);
		user1.setB("2" + b);
		
		logger.info("-------------------{}--------------{}", user, user1);
		
		List list = new ArrayList();
		list.add(user);
		list.add(user1);
		
		testDAO.insert(user);
		testDAO.insert(user1);

		return JSON.toJSONString(list);
	}
	
	@RequestMapping("/geta")
	public String geta(@RequestParam("key") String key) {
		Object o = redisTemplate.opsForValue().get("test::" + key);
		if ( null == o) {
			return "null";
		}

		return (String)o;
	}

	@LcnTransaction
	@Transactional
	@RequestMapping("/update")
	public String update(@RequestParam("a") String a, @RequestParam("b") String b) {
		testDAO.update(a, b);
		return (a + b);
	}

	@RequestMapping("/set")
	public String setKV(@RequestParam("key") String key, @RequestParam("val") String val) {
		jedisCluster.set(key, val);

		return jedisCluster.get(key);
	}

	@RequestMapping("/set2")
	public String setKV2(@RequestParam("key") String key, @RequestParam("val") String val) {
		redisTemplate.opsForValue().set(key, val);
		return (String) redisTemplate.opsForValue().get(key);
	}
}

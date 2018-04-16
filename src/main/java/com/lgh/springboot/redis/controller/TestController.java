package com.lgh.springboot.redis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
public class TestController {
	@Autowired
	private StringRedisTemplate redisTemplate;

	@GetMapping("/redis/{key}")
	public String get(@PathVariable String key) {
		String value = redisTemplate.opsForValue().get(key);
		log.info("get {}={}", key, value);
		return value;
	}

	@PostMapping("/redis/{key}")
	public String post(@PathVariable String key, @RequestParam String value) {
		redisTemplate.opsForValue().set(key, value);
		log.info("set {}={}", key, value);
		return value;
	}

}

package com.limitservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.limitservice.entity.LimitConfig;

@RestController
public class LimitCintroller {
	
	@Autowired
	private LimitConfig config;

	@GetMapping(value="cloud")
	public LimitConfig LimitconfigServer()
	{
		return config;	
	}
	
	
}

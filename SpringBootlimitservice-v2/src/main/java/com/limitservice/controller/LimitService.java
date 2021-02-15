package com.limitservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.limitservice.configuration.Configuration;
import com.limitservice.entity.Limits;

@RestController
public class LimitService {
	
	@Autowired
	private Configuration configuration;
	
	@GetMapping("limits")
	public Limits retriveLimits() {
		return new Limits(configuration.getMax(),configuration.getMin());
		
	}

}

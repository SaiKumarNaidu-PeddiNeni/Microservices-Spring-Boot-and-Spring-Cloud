package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.service.FirstService;

import lombok.extern.slf4j.Slf4j;



@RestController
@Slf4j
public class FirstController {
	
	@Autowired
	private FirstService firstService;

	@GetMapping(value="greet/{hello}")
	public String helloWorld(@PathVariable("hello") String hello)
	{
		
		return firstService.greet(hello);
	}
	
}

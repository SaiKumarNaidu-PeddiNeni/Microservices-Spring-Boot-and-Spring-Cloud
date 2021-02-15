package com.example.demo.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClientController {

	@GetMapping(value="greet")
	public String greet()
	{
		return "Happy New Year and welcome to Eureka Server";
	}
	
}

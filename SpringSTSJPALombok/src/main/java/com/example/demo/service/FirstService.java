package com.example.demo.service;

import org.slf4j.Logger;
import org.springframework.stereotype.Service;


import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class FirstService {

	public String greet(String greet)
	{
		return greet;
	}
}

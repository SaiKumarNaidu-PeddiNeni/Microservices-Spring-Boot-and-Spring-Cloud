package com.ams.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ams.entity.Hanger;

import com.ams.service.HangerService;

@RestController
public class HangerController {
	
	@Autowired
	private HangerService hangerService;

	@PostMapping("/hangerdetails")
	public ResponseEntity<Hanger> addHanger(@RequestBody Hanger hanger)
	{
		try {
		hangerService.addHanger(hanger);
		return new ResponseEntity<Hanger>(hanger, HttpStatus.CREATED);
		}
		catch(Exception e)
		{
			return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
		}
	}
}

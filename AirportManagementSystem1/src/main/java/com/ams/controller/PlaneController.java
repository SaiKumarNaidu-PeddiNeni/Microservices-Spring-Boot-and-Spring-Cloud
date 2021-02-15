package com.ams.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ams.entity.Plane;
import com.ams.service.PlaneService;

@RestController
public class PlaneController {
	
	@Autowired
	private PlaneService planeService;
	@PostMapping("/AddPlane")
	public ResponseEntity<Plane> addHanger(@RequestBody Plane plane)
	{	
		try {
		planeService.addPlane(plane);
		return new ResponseEntity<Plane>(plane, HttpStatus.CREATED);
		}
		catch(Exception e)
		{
			return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
		}
	}
}

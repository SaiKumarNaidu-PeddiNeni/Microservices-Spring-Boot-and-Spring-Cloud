package com.ams.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ams.entity.Plane;
import com.ams.repository.PlaneRepository;
@Transactional
@Service
public class PlaneServiceImpl implements PlaneService {

	@Autowired
	private PlaneRepository planeRepository; 
	
	
	@Override
	public Plane addPlane(Plane plane) {
		
		return planeRepository.save(plane);
	}

}

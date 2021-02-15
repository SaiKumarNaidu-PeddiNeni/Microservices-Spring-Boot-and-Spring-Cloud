package com.ams.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ams.entity.Hanger;
import com.ams.repository.HangerRepository;
@Transactional
@Service
public class HangerServiceImpl implements HangerService {
	
	@Autowired
	private HangerRepository hangerRepository;

	@Override
	public Hanger addHanger(Hanger hanger) {
		
		return hangerRepository.save(hanger);
	}

}

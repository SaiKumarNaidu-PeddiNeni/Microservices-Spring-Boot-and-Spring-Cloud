package com.angular.integration.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.angular.integration.entity.Customer;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {
	
	@Autowired
	private CustomerServiceImpl customerServiceImpl;

	@Override
	public Customer save(Customer customer) {
		return customerServiceImpl.save(customer);
	}

}

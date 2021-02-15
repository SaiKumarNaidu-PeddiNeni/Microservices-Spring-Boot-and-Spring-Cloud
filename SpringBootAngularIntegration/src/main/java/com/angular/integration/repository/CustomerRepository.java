package com.angular.integration.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;


import com.angular.integration.entity.Customer;


public interface CustomerRepository extends CrudRepository<Customer, Long> {
	
	List<Customer> findByAge(int age);

}

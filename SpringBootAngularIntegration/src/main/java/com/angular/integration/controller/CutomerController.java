package com.angular.integration.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.angular.integration.entity.Customer;
import com.angular.integration.repository.CustomerRepository;
import com.angular.integration.service.CustomerService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
public class CutomerController {
	
	@Autowired
	private CustomerService customerService;
	
	@Autowired
	private CustomerRepository customerRepository;
	
	@PostMapping(value="/customers")
	public ResponseEntity<Customer> postCustomer(@RequestBody Customer customer)
	{
		try {
			Customer customer1= customerRepository.save(new Customer(customer.getName(),customer.getGender(),customer.getAge()));
			return new ResponseEntity<Customer>(customer1, HttpStatus.CREATED);
		}
		catch(Exception e)
		{
			return new ResponseEntity<>(null, HttpStatus.EXPECTATION_FAILED);
		}
	}
	@GetMapping(value="/customers")
	public ResponseEntity<List<Customer>> getAllCustomers(){	
		List<Customer> customers= new ArrayList<Customer>();
		try {
			customerRepository.findAll().forEach(customers::add);
			
			if(customers.isEmpty())
			{
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(customers,HttpStatus.OK);
		}
		catch(Exception e)
		{
			return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@GetMapping(value="/customers/{id}")
	public ResponseEntity<Customer> getCustomerById(@PathVariable("id") long id)
	{
		Optional<Customer> customerData = customerRepository.findById(id);
		if(customerData.isPresent())
		{
			return new ResponseEntity<>(customerData.get(),HttpStatus.OK);
		}
		else
		{
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
	}
	@PutMapping(value="/customers/update")
	public Customer updateCustomer(@RequestBody Customer customer)
	{
		System.out.println(customer);
		Customer customer1= customerRepository.save(new Customer(customer.getId(),customer.getName(),customer.getGender(),customer.getAge()));
		return customer1;
		
	}
	@DeleteMapping("/customers/{id}")
	public ResponseEntity<HttpStatus> deleteCustomer(@PathVariable("id") long id)
	{
		try
		{
			customerRepository.deleteById(id);
			return new ResponseEntity<HttpStatus>(HttpStatus.NO_CONTENT);
		}
		catch(Exception e)
		{
			return new ResponseEntity<HttpStatus>(HttpStatus.EXPECTATION_FAILED);
		}
	}
	@DeleteMapping("/customers")
	public ResponseEntity<HttpStatus> deleteCustomers()
	{
		try
		{
			customerRepository.deleteAll();
			return new ResponseEntity<HttpStatus>(HttpStatus.NO_CONTENT);
		}
		catch(Exception e)
		{
			return new ResponseEntity<HttpStatus>(HttpStatus.EXPECTATION_FAILED);
		}
	}
	
	@GetMapping(value="/customers/age/{age}")
	public ResponseEntity<List<Customer>> findByAge(@PathVariable("age") int age)
	{
		try
		{
			List<Customer> customers = customerRepository.findByAge(age);
			if(customers.isEmpty())
			{
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			else
			{
				return new ResponseEntity<>(customers,HttpStatus.OK);
			}
		}
		catch(Exception e)
		{
			return new ResponseEntity<>(HttpStatus.EXPECTATION_FAILED);
		}
		
	}
	
}

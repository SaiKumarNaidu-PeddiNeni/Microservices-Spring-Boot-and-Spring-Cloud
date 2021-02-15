package com.example.demo.service;


import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.demo.applicationException.ApplicationException;
import com.example.demo.dao.DepartmentDao;
import com.example.demo.entity.DepartmentDetails;
import com.example.demo.entity.EmployeeDetails;
import com.example.demo.entity.EmployeeDetailsList;

@Service
public class DepartmentServiceImpl implements DepartmentService {
	
	@Autowired
	private DepartmentDao departmentDao;
	
	@Autowired
	private RestTemplate restTemplate;

	@Override
	public DepartmentDetails save(DepartmentDetails department) {
		
		return departmentDao.save(department);
	}

	@Override
	public DepartmentDetails getDepartmentbyDepartmentNo(int departmentNumber) throws ApplicationException {
		
		Optional<DepartmentDetails> optional = departmentDao.findById(departmentNumber);
		if (optional.isPresent())
			return optional.get();
		else
			throw new ApplicationException("Record Not Found - No Such Employee");
	}
	
	public List<EmployeeDetails> getEmployeeDetails(String department)
	{
		String uri= "http://localhost:9090/getdepartment/" + department;
		
		//EmployeeDetails details = restTemplate.getForObject(uri, EmployeeDetails.class);
		
		ResponseEntity<EmployeeDetails[]> response = restTemplate.getForEntity(uri, EmployeeDetails[].class);
		
		/*
		 * EmployeeDetailsList response =
		 * restTemplate.getForObject(uri,EmployeeDetailsList.class);
		 * List<EmployeeDetails> employees = response.getEmployees();
		 */
		List<EmployeeDetails> employees = Arrays.asList(response.getBody());
			
		return employees;	
	}
	
	public EmployeeDetails getEmployee(long id)
	{
		String uri= "http://localhost:9090/get/" + id;
		
		EmployeeDetails details = restTemplate.getForObject(uri, EmployeeDetails.class);
		
		return details;	
	}
}

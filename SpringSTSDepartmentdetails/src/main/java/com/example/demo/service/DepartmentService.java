package com.example.demo.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

//import org.springframework.http.ResponseEntity;

import com.example.demo.applicationException.ApplicationException;
import com.example.demo.entity.DepartmentDetails;
import com.example.demo.entity.EmployeeDetails;

public interface DepartmentService {
	
	public abstract DepartmentDetails save(DepartmentDetails department);
	
	public abstract DepartmentDetails getDepartmentbyDepartmentNo(int departmentNumber)throws ApplicationException;
	
	public abstract List<EmployeeDetails> getEmployeeDetails(String department);
	
	public abstract EmployeeDetails getEmployee(long id);

}

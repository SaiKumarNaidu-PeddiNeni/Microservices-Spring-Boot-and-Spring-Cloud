package com.example.demo.EmployeeService;

import java.util.List;

import com.example.demo.ApplicationException.ApplicationException;
import com.example.demo.Entity.EmployeeDetails;

public interface EmployeeService {

	public abstract EmployeeDetails saveEmployee(EmployeeDetails employee);
	
	public abstract EmployeeDetails getEmployeebyId(int employeeId)throws ApplicationException;

	public abstract List<EmployeeDetails> getEmployeebyDepartment(String department)throws ApplicationException;
	
	
}

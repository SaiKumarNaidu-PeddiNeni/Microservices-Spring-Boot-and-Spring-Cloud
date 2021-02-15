package com.example.demo.departmentController;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.applicationException.ApplicationException;
import com.example.demo.entity.DepartmentDetails;
import com.example.demo.entity.EmployeeDetails;
import com.example.demo.service.DepartmentService;

@RestController
public class DepartmentController {
	
	@Autowired
	private DepartmentService departmentService;
	
	@PostMapping(value = "/save")
	public DepartmentDetails saveEmployee(@RequestBody DepartmentDetails department)
	{
		return departmentService.save(department);	
	}
	
	@GetMapping(value="/get/{id}")
	public DepartmentDetails readEmployee(@PathVariable("id") int  id) throws ApplicationException
	{
		DepartmentDetails employee= new DepartmentDetails(); 
		try {
		employee = departmentService.getDepartmentbyDepartmentNo(id);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return employee;
	}
	
	@GetMapping(value="/getByDept/{department}")
	public List<EmployeeDetails> getEmployeeDetails(@PathVariable("department") String department)
	{
		return departmentService.getEmployeeDetails(department);
	}
	
	@GetMapping(value="/getBy/{id}")
	public EmployeeDetails getEmployee(@PathVariable("id") long id)
	{
		return departmentService.getEmployee(id);
	}
}

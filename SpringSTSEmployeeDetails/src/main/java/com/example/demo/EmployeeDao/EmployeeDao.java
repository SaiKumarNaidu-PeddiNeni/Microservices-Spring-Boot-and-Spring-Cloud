package com.example.demo.EmployeeDao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import com.example.demo.Entity.EmployeeDetails;

public interface EmployeeDao extends JpaRepository<EmployeeDetails, Integer>{
	
	public List<EmployeeDetails> findByDepartmentName(String department);

}

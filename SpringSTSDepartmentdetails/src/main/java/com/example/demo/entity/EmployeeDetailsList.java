package com.example.demo.entity;

import java.util.ArrayList;
import java.util.List;

public class EmployeeDetailsList {
	
	private List<EmployeeDetails> employees;

    public EmployeeDetailsList() {
        employees = new ArrayList<>();
    }

	

	public List<EmployeeDetails> getEmployees() {
		return employees;
	}

	public void setEmployees(List<EmployeeDetails> employees) {
		this.employees = employees;
	}



	public EmployeeDetailsList(List<EmployeeDetails> employees) {
		super();
		this.employees = employees;
	}


}

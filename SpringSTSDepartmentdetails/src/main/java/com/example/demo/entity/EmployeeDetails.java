package com.example.demo.entity;

public class EmployeeDetails  {

	private int employeeId;
	
	private String employeeName;
	
	private String departmentName;
	
	private float employeeSalary;
	
	public EmployeeDetails() {
		super();
		
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public float getEmployeeSalary() {
		return employeeSalary;
	}

	public void setEmployeeSalary(float employeeSalary) {
		this.employeeSalary = employeeSalary;
	}
	public EmployeeDetails(int employeeId, String employeeName, String departmentName, float employeeSalary) {
		super();
		this.employeeId = employeeId;
		this.employeeName = employeeName;
		this.departmentName = departmentName;
		this.employeeSalary = employeeSalary;
	}
}

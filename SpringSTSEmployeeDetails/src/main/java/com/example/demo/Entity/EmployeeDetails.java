package com.example.demo.Entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;


@Entity
@Table(name="EmployeeDetails_Table")
public class EmployeeDetails implements Serializable {

	/**{"employeeId":10,"employeeName":"sai","DepartmentName":"FS","employeeSalary":22250f}
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int employeeId;
	
	@Size(min=2)
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

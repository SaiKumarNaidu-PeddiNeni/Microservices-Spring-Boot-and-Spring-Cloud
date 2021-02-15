package com.example.demo.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="DepartmentDetails_Table")
public class DepartmentDetails implements Serializable {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int departmentNo;
	
	private String departmentName;
	

	public int getDepartmentNo() {
		return departmentNo;
	}

	public void setDepartmentNo(int departmentNo) {
		this.departmentNo = departmentNo;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public DepartmentDetails(int departmentNo, String departmentName) {
		super();
		this.departmentNo = departmentNo;
		this.departmentName = departmentName;
	}

	public DepartmentDetails() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	

}

package com.ams.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="Plane")
public class Plane implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String planeId;
	
	private String planeName;
	
	private String Location;
	
	public long getId() {
		return id;
	}

	public Plane() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Plane(long id, String planeId, String planeName, String location) {
		super();
		this.id = id;
		this.planeId = planeId;
		this.planeName = planeName;
		Location = location;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getPlaneId() {
		return planeId;
	}

	public void setPlaneId(String planeId) {
		this.planeId = planeId;
	}

	public String getPlaneName() {
		return planeName;
	}
	public void setPlaneName(String planeName) {
		this.planeName = planeName;
	}
	public String getLocation() {
		return Location;
	}
	public void setLocation(String location) {
		Location = location;
	}
}

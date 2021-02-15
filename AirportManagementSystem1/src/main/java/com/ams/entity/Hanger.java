package com.ams.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="Hanger")
public class Hanger implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long hangerId;
	
	private String hangerLocation;

	public Hanger() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Hanger(long hangerId, String hangerLocation) {
		super();
		this.hangerId = hangerId;
		this.hangerLocation = hangerLocation;
	}

	public long getHangerId() {
		return hangerId;
	}

	public void setHangerId(long hangerId) {
		this.hangerId = hangerId;
	}

	public String getHangerLocation() {
		return hangerLocation;
	}

	public void setHangerLocation(String hangerLocation) {
		this.hangerLocation = hangerLocation;
	}
	
	
	
	

}

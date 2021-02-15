package com.example.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.DepartmentDetails;

public interface DepartmentDao extends JpaRepository<DepartmentDetails, Integer> {

}

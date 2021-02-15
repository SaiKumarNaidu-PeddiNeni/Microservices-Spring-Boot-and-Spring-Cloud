package com.ams.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ams.entity.Plane;

public interface PlaneRepository extends JpaRepository<Plane, Long> {

}

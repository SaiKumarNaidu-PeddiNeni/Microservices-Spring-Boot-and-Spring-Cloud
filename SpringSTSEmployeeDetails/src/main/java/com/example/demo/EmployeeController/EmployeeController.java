package com.example.demo.EmployeeController;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.hateoas.*;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;


import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;



import com.example.demo.ApplicationException.ApplicationException;
import com.example.demo.EmployeeService.EmployeeService;
import com.example.demo.Entity.EmployeeDetails;

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@PostMapping(value = "/save")
	public ResponseEntity<Object> saveEmployee(@Valid @RequestBody EmployeeDetails employee) {
		EmployeeDetails employee1 = employeeService.saveEmployee(employee);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{employeeId}")
				.buildAndExpand(employee1.getEmployeeId()).toUri();
		return ResponseEntity.created(location).build();

	}

	@GetMapping(value = "/get/{id}")
	public EntityModel<EmployeeDetails> readEmployee(@PathVariable("id") int id) throws ApplicationException {
		EmployeeDetails employee = new EmployeeDetails();
		try {
			employee = employeeService.getEmployeebyId(id);
		} catch (Exception e) {
			throw new ApplicationException("Id not found:" + id);
		}
		EntityModel<EmployeeDetails> resource = EntityModel.of(employee);

		WebMvcLinkBuilder linkTo = linkTo(methodOn(this.getClass()).readEmployees());

		resource.add(linkTo.withRel("Save-Employee"));


		return resource;

		
	}
	
	@GetMapping(value = "/getall")
	public List<EmployeeDetails> readEmployees()
			throws ApplicationException {
		return null;
	}


	@GetMapping(value = "/getdepartment/{department}")
	public List<EmployeeDetails> readEmployeebyDepartment(@PathVariable("department") String department)
			throws ApplicationException {
		return employeeService.getEmployeebyDepartment(department);
	}
}

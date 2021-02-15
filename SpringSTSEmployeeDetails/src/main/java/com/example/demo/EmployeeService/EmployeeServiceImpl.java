package com.example.demo.EmployeeService;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.ApplicationException.ApplicationException;
import com.example.demo.EmployeeDao.EmployeeDao;
import com.example.demo.Entity.EmployeeDetails;
@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeDao employeeDao; // Dependency Injection.
	
	@Override
	public EmployeeDetails saveEmployee(EmployeeDetails employee) {
		return employeeDao.save(employee);
	}

	@Override
	public EmployeeDetails getEmployeebyId(int employeeId) throws ApplicationException {
		
		Optional<EmployeeDetails> optional = employeeDao.findById(employeeId);
		if (optional.isPresent())
			return optional.get();
		else
			throw new ApplicationException("Record Not Found - No Such Employee");
	}

	@Override
	public List<EmployeeDetails> getEmployeebyDepartment(String department) throws ApplicationException {
		
		return employeeDao.findByDepartmentName(department);
		
	}

}

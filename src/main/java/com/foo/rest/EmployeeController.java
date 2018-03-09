package com.foo.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.foo.data.Employee;
import com.foo.data.EmployeeRepository;

@RestController
public class EmployeeController {
	@Autowired
	private EmployeeRepository er;

	public Employee getEmployee(long id) {
		return er.findOne(id);
	}

}

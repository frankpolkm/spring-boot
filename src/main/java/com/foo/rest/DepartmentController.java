package com.foo.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.foo.data.Department;
import com.foo.data.DepartmentRepository;

@RestController
public class DepartmentController {
	@Autowired
	private DepartmentRepository ds;

	@GetMapping("/dep/count")
	public long getDepartmentCount() {
		return ds.count();
	}
	
	@GetMapping("/dep/{id}")
	public ResponseEntity<Department> getDepartmentById(@PathVariable("id") Long id) {
		Department d = ds.findOne(id);
		if(d == null) {
			return new ResponseEntity<Department>(HttpStatus.NOT_FOUND);
		} else {
			return new ResponseEntity<Department>(d, HttpStatus.OK);
		}
	}
}

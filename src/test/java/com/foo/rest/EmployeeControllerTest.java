package com.foo.rest;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import com.foo.data.Employee;
import com.foo.data.EmployeeRepository;

@RunWith(MockitoJUnitRunner.class)
public class EmployeeControllerTest {
	@InjectMocks
	private EmployeeController ec;
	
	@Mock
	private EmployeeRepository er;
	
	@Before
	public void setup() {
		MockitoAnnotations.initMocks(ec);
	}

	@Test
	public void getEmployeeById() {
		Mockito.when(er.findOne((long) 1001)).thenReturn(new Employee("Tom", "Cate"));
		
		Employee e = ec.getEmployee(1001);
		Assert.assertNotNull(e);
		Assert.assertEquals("Tom", e.getFirstName());
		Assert.assertEquals("Cate", e.getLastName());
	}
}

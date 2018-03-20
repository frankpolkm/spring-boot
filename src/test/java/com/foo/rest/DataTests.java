package com.foo.rest;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.foo.data.Department;
import com.foo.data.DepartmentRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DataTests {
	@Autowired
	private DepartmentRepository departmentRepository;
    
	@Test
	public void getDepartmentCount() {
		long count = departmentRepository.count();
		Assert.assertEquals(3, count);
	}
	
    
	@Test
	public void getDepartmentNotExists() {
		long count = departmentRepository.count();
		Assert.assertEquals(3, count);
		
		List<Department> ds = departmentRepository.findByName("ABC");
		Assert.assertTrue("Should return empty list", ds.isEmpty());
	}
	
    
	@Test
	public void getDepartmentIT() {
		long count = departmentRepository.count();
		Assert.assertEquals(3, count);
		
		Department it = departmentRepository.findOne((long)1);
		Assert.assertEquals("IT", it.getName());
		Assert.assertEquals(Long.valueOf(1), it.getId());
	}
 
}

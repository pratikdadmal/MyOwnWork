package com.SpringBootDemoProject;

import static org.mockito.Mockito.when;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import com.SpringBootDemoProject.controller.EmployeeController;
import com.SpringBootDemoProject.entity.Employee;
import com.SpringBootDemoProject.services.Employeeservice_infer;

import junit.framework.Assert;

@SpringBootTest
@RunWith(SpringRunner.class)
class SpringBootDemoProjectApplicationTests {

	//@InjectMocks
	@Autowired
	EmployeeController employeecontroller;
	
	@MockBean
	Employeeservice_infer employeeservice_infer;
	
	@Test
	public void saveEmployeeTest()
	{
		Employee employee = new Employee();
		 
		when(employeeservice_infer.saveEmployee(employee)).thenReturn(true);
		
		boolean result = employeecontroller.saveEmployee(employee);
		Assert.assertNotNull(result);
		
	}

}

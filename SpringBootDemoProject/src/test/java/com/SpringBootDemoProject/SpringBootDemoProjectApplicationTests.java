package com.SpringBootDemoProject;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.mockito.Mockito;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.junit4.SpringRunner;

import com.SpringBootDemoProject.controller.EmployeeController;
import com.SpringBootDemoProject.dao.EmployeeDao_Impl;
import com.SpringBootDemoProject.entity.Employee;
import com.SpringBootDemoProject.services.EmployeeService_Impl;
import com.SpringBootDemoProject.services.Employeeservice_infer;


@SpringBootTest
@RunWith(SpringRunner.class)
//@ActiveProfiles("test")
//@RunWith(SpringJUnit4ClassRunner.class)
class SpringBootDemoProjectApplicationTests {

	//@InjectMocks
	@Autowired
	private EmployeeService_Impl employeeService_impl;
	
	@MockBean
	private EmployeeDao_Impl employeeDao_impl;
	
	@Test
	public void saveEmployeeTest()
	{
		Employee employee = new Employee();
		 
//		Mockito.when(employeeService_impl.saveEmployee(employee)).thenReturn(true);
//		boolean result = employeeService_impl.saveEmployee(employee);
//        Assert.assertEquals(employee, result);
		
		assertThat(employeeService_impl.EmployeeList(employee));
		
	}

}

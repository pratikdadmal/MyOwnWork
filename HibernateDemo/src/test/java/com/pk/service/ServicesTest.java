package com.pk.service;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;

import com.pk.entity.User;

@RunWith(MockitoJUnitRunner.class)
public class ServicesTest {
	
    @InjectMocks
	Services services;
	
	@Test
	public void saveData1()
	{
		User user = new User();
		
		String str = services.saveData(user);
		Assert.assertNotNull(str);
		
	}
	
	@Test
	public void getUserIDtest()
	{
		User user = new User();
		user.setId(12);
		User user1 = services.getUserID(12);	
		Assert.assertEquals(12, user1);
	}
	
    @Test
	public void deleteTest()
	{
    	User user = new User();
    	user.setId(54);
    	String str = services.deleteData(54);
    	Assert.assertEquals(54, str);
	}
    
    @Test
    public void getAlluserTest()
    {
    	User user = new User();
    	List<User> list1 = services.getAllUser();
    	Assert.assertNotNull(list1);
    }
    
    @Test
    public void updateuserTest()
    {
    	User user = new User();
    	user.setId(45);
    	String strr = services.updateUserData(45);
    	Assert.assertNotNull(strr);
    }
    
    @Test
    public void updateIDTest()
    {
    	User user = new User();
    	user.setId(12);
    	String upstr = services.updateID(12);
    	Assert.assertNotNull(upstr);
    }
    
    @Test
    public void updateNameTest()
    {
    	User user = new User();
    	user.setName("om");
    	String upstr = services.updateName(1);
    	Assert.assertNotNull(upstr);
    }
    
    @Test
    public void updateDepartmentTest()
    {
    	User user = new User();
    	user.setDepartment("it");
    	String upstr = services.updateDepartment(1);
    	Assert.assertNotNull(upstr);
    }
    
    @Test
    public void updatePhooneTest()
    {
    	User user = new User();
    	user.setPhone("34");
    	String upstr = services.updatePhone(23);
    	Assert.assertNotNull(upstr);
    }
    
    
    @Test
    public void updatecityTest()
    {
    	User user = new User();
    	user.setCity("pune");
    	String upstr = services.updateCity(1);
    	Assert.assertNotNull(upstr);
    }
    
    @Test
    public void updatSalaryTest()
    {
    	User user = new User();
    	user.setSalary("423");
    	String upstr = services.updateSalary(2);
    	Assert.assertNotNull(upstr);
    }
    
    @Test
    public void hightSalaryTest()
    {
    	User user = new User();
    	List<User> list1 = services.getHighestSalary("80000");
    	Assert.assertNotNull(list1);
    }
    
    @Test
    public void maxSalaryTest()
    {
    	User user = new User();
    	String s = services.maxSalary();
    	Assert.assertNotNull(s);
    }
    
    @Test
    public void avgSalaryTest()
    {
    	User user = new User();
    	double d = services.avgSalary();
    	Assert.assertNotNull(d);
    }
}


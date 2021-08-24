package com.ATMTransaction.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ATMTransaction.DAO.UserRepository_Interface;
import com.ATMTransaction.Entity.User1ATM;
import com.ATMTransaction.Services.UserService;

@RestController
@RequestMapping("/insert")
public class UserController {
	
	@Autowired
	private UserService userservice;
	
	@Autowired(required=true)
	private UserRepository_Interface userrepository_interface;
	
	@PostMapping(value="/insertdata")
	public boolean insertDetails(@RequestBody User1ATM user)
	{
		boolean b = userservice.insertDetails(user);
		return b;
	}

	@GetMapping(value="/getdata")
	public List<User1ATM> getAlldata()
	{
		List<User1ATM> list = userrepository_interface.getAlldata();
		list.forEach(e->{System.out.println(e);
		});
		return list;
	}
	
	@GetMapping(value="/getAmount")
	public List<User1ATM> getAmount(@RequestParam Integer account)
	{
		List<User1ATM> list = userrepository_interface.getAmountByAccount(account);
		list.forEach(e->{System.out.println(e);
		});
		return list;
	}
}

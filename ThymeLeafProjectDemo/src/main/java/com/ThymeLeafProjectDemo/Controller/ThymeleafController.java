package com.ThymeLeafProjectDemo.Controller;

import java.net.http.HttpClient.Redirect;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.cglib.proxy.Dispatcher;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.DispatcherServlet;

@Controller
public class ThymeleafController {

	
	@RequestMapping(value="/about", method = RequestMethod.GET)
	public String about(Model model)
	{
		System.out.println("In side About Handler"); 
		
		model.addAttribute("msg","Pratik Dadmal");//send the value to frontend
		model.addAttribute("currentdate", new Date().toLocaleString());

		return "about"; //about.html
	}

	

	
}

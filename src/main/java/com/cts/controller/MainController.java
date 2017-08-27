package com.cts.controller;

import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.cts.service.LoginAddServiceImpl;

@RestController
public class MainController {
    
	@Autowired
	private LoginAddServiceImpl add;
	
	public void setAdd(LoginAddServiceImpl add) {
		this.add = add;
	}
    
	@RequestMapping(value= "/log")
	public ModelAndView initLoginPage() {
		ModelAndView view = new ModelAndView();
		view.setViewName("loginpage");
		return view;
	}
	
	@RequestMapping(value = "/add" ,method = RequestMethod.POST)
	@ResponseBody
	public ModelAndView loginAdd(@RequestParam("name") String name,
			                     @RequestParam("password")String password, 
			                     Model map) {

	/*
		@SuppressWarnings("resource")
		ApplicationContext ctx = new ClassPathXmlApplicationContext("dispatcher-servlet.xml");
		 	 
	    DefaultSqlSessionFactory sessionFactory  = (DefaultSqlSessionFactory) ctx.getBean("sqlSessionFactory");*/
		
		
		add.addLoginDetails(name, password);
		
		ModelAndView view = new ModelAndView();
		view.setViewName("loginpage");
		return view;
	}
}

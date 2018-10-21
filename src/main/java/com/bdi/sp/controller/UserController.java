package com.bdi.sp.controller;



import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bdi.sp.service.LoginService;
import com.bdi.sp.vo.Login;

@Controller
public class UserController {
	@Autowired
	private LoginService ls;
	@RequestMapping(value="/wndqhr", method=RequestMethod.POST)
	public @ResponseBody Map<String,String> login(@RequestBody Login userz){
		return ls.wndqhrcpzm(userz);
		
	}
}
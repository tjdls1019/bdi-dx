package com.bdi.sp.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bdi.sp.service.LoginService;
import com.bdi.sp.vo.Login;

@Controller
public class LoginController {

	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
	
	@Autowired
	private LoginService ls;
	
	@RequestMapping(value="/login",method=RequestMethod.GET)
	public @ResponseBody List<Login> loginList(@ModelAttribute Login li) {
		return ls.getLoginList(li);
	}
	
	@RequestMapping(value="/login/{linum}", method=RequestMethod.GET)
	public @ResponseBody Login loginOne(@PathVariable Integer linum) {
		return ls.getLogin(linum);
	}
	
	@RequestMapping(value="/signup", method=RequestMethod.POST)
	public @ResponseBody Map<String,String> insertLogin(@RequestBody Login li) {
		logger.debug("login=>{}", li);
		return ls.insertLogin(li);
	}
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public @ResponseBody Map<String,String> loginCheck(@RequestBody Login li,HttpServletRequest req) {
		logger.debug("login=>{}", li);
		return ls.loginCheck(li,req);
				
	}
	
	@RequestMapping(value="/login", method=RequestMethod.PUT)
	public @ResponseBody Map<String,String> updateLogin(@RequestBody Login li) {
		
		logger.debug("login=>{}", li);
		return ls.updateLogin(li);
	}
	
	@RequestMapping(value="/login/{linum}", method=RequestMethod.DELETE)
	public @ResponseBody Map<String,String> deleteLogin(@RequestBody Login li, @PathVariable Integer linum) {
		logger.debug("login=>{}", li);
		return ls.deleteLogin(linum);
	}
}
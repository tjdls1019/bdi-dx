package com.bdi.sp.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class URIController {

	private static final Logger logger = LoggerFactory.getLogger(URIController.class);
	
	@RequestMapping(value="/uri/**", method=RequestMethod.GET)
	public String goPage(HttpServletRequest req) {
		String rootPath = req.getContextPath();
		String pathz= req.getRequestURI();
		logger.debug("rootPath=>{}",rootPath);
		logger.debug("requestPath=>{}",pathz);
		return req.getRequestURI().replace(rootPath+"/uri", "");
	}
	/*@RequestMapping(value="/uriz/dx/**", method=RequestMethod.GET)
	public String goPage2(HttpServletRequest req) {
		HttpSession hs =req.getSession();// 
		String rootPath = req.getContextPath();
		//hs.setAttribute("token","0");//초기화부분..
		//System.out.println(hs.getAttribute("ssuser"));
		logger.debug("rootPath=>{}",rootPath);
		//if(hs.getAttribute("token").equals("1")) {
	//		logger.debug("uri=>{}",req.getRequestURI().replace(rootPath+"/uriz", ""));
		return req.getRequestURI().replace(rootPath+"/uriz", "");
		}else {
			return req.getRequestURI().replaceAll(rootPath+"/uriz/dx/list", "/uri/dx/login");
		}
	}*/
	
}

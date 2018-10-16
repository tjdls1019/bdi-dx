package com.bdi.sp.controller;

import java.util.List;

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

import com.bdi.sp.service.DepartService;
import com.bdi.sp.vo.Depart;
import com.bdi.sp.vo.Japan;

@Controller
public class DepartController {

	private static final Logger logger = LoggerFactory.getLogger(DepartController.class);
	
	@Autowired DepartService ds;
	
	@RequestMapping(value="/departs",method=RequestMethod.GET)
	public @ResponseBody List<Depart> departList(@ModelAttribute Depart d) {
		return ds.getDepartList(d);
	}
	
	@RequestMapping(value="/departs/{dino}", method=RequestMethod.GET)
	public @ResponseBody Depart departList(@PathVariable Integer dino) {
		return ds.getDepart(dino);
	}
	
	@RequestMapping(value="/departs/{dino}", method=RequestMethod.POST)
	public @ResponseBody int insertDepart(@ModelAttribute Depart d, @PathVariable Integer dino) {
		logger.debug("depart=>{}", d);
		return ds.insertDepart(d);
	}
	
	@RequestMapping(value="/departs/{dino}", method=RequestMethod.PUT)
	public @ResponseBody int updateJapan(@RequestBody Depart d, @PathVariable Integer dino) {
		logger.debug("depart=>{}", d);
		return ds.updateDepart(d);
	}
	
	@RequestMapping(value="/departs/{dino}", method=RequestMethod.DELETE)
	public @ResponseBody int deleteJapan(@RequestBody Depart d, @PathVariable Integer dino) {
		logger.debug("depart=>{}", d);
		return ds.deleteDepart(dino);
	}
}

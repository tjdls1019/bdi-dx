package com.bdi.sp.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {
	
	
	@RequestMapping(value="/login", method=RequestMethod.PUT)
	public @ResponseBody Map<String,String> loginUp(@RequestBody Map<String,String> Uper){
		Map<String,String> rMap = new HashMap<String,String>();
		rMap.put("login","fail");
		rMap.put("msg", "수정이안댐요");
		if(Uper.get("id")==null) {
			return rMap;
		}
		
		if(Uper.get("name").equals("test")) {
			if(Uper.get("id").equals("test")) {
				if(Uper.get("pwd").equals("test")) {
					if(Uper.get("pwdcheck").equals("test")) {
						if(Uper.get("email").equals("test")) {
							if(Uper.get("address").equals("test")) {
								if(Uper.get("gender").equals("여")) {
									if(Uper.get("birth").equals("test")) {
										if(Uper.get("recommender").equals("test")) {
											rMap.put("login", "success");
											rMap.put("msg","수정성공.");
										}
									}
								}
							}
						}
					}
				}
			}
		}
		return rMap;
	}
	
	
	

	@RequestMapping(value="/login", method=RequestMethod.POST)
	public @ResponseBody Map<String,String> login(@RequestBody Map<String,String> user){
		Map<String,String> rMap = new HashMap<String,String>();
		rMap.put("login","fail");
		rMap.put("msg", "아이디및 비밀번호를 확인하세요");
		if(user.get("id")==null) {
			return rMap;
		}
		
		if(user.get("id").equals("test1")) {
			if(user.get("pwd").equals("test1")) {
				rMap.put("login", "success");
				rMap.put("msg","로그인 되었습니다.");
			}
		}
		return rMap;
	}
}

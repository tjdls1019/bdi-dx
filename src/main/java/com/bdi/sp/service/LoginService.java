package com.bdi.sp.service;

import java.util.List;
import java.util.Map;

import com.bdi.sp.vo.Login;

public interface LoginService {

	public List<Login> getLoginList(Login li);
	public Login getLogin(int linum);
	public Map<String,String> insertLogin(Login li);
	public Map<String,String> updateLogin(Login li);
	public int deleteLogin(int linum);
	public Map<String,String> wndqhrcpzm(Login li);
	public Map<String,String> loginCheck(Login li);
}

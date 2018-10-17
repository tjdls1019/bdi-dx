package com.bdi.sp.service;

import java.util.List;

import com.bdi.sp.vo.Login;

public interface LoginService {

	public List<Login> getLoginList(Login li);
	public Login getLogin(int linum);
	public int insertLogin(Login li);
	public int updateLogin(Login li);
	public int deleteLogin(int linum);
}

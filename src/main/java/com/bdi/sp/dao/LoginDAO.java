package com.bdi.sp.dao;

import java.util.List;

import com.bdi.sp.vo.Login;

public interface LoginDAO {

	public List<Login> getLoginList(Login li);
	public Login getLogin(int linum);
	public int insertLogin(Login li);
	public int updateLogin(Login li);
	public int deleteLogin(int linum);
	public Login dupcheck(Login li);
	public Login fhrmdlstlfvo(Login li);
}

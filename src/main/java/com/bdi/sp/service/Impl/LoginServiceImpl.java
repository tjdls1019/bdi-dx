package com.bdi.sp.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bdi.sp.dao.LoginDAO;
import com.bdi.sp.service.LoginService;
import com.bdi.sp.vo.Login;

@Service
public class LoginServiceImpl implements LoginService{
	
	@Autowired
	private LoginDAO ldao;

	@Override
	public List<Login> getLoginList(Login li) {
		return ldao.getLoginList(li);
	}

	@Override
	public Login getLogin(int linum) {
		return ldao.getLogin(linum);
	}

	@Override
	public int insertLogin(Login li) {
		return ldao.insertLogin(li);
	}

	@Override
	public int updateLogin(Login li) {
		return ldao.updateLogin(li);
	}

	@Override
	public int deleteLogin(int linum) {
		return ldao.deleteLogin(linum);
	}

}

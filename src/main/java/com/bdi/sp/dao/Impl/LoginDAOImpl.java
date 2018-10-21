package com.bdi.sp.dao.Impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bdi.sp.dao.LoginDAO;
import com.bdi.sp.vo.Login;

@Repository
public class LoginDAOImpl implements LoginDAO{

	@Autowired
	private SqlSession ss;
	@Override
	public List<Login> getLoginList(Login li) {
		return ss.selectList("Login.selectLoginList",li);
	}

	@Override
	public Login getLogin(int linum) {
		return ss.selectOne("Login.selectLogin",linum);
	}

	@Override
	public int insertLogin(Login li) {
		return ss.insert("Login.insertLogin",li);
	}

	@Override
	public int updateLogin(Login li) {
		return ss.update("Login.updateLogin",li);
	}

	@Override
	public int deleteLogin(int linum) {
		return ss.delete("Login.deleteLogin",linum);
	}

	@Override
	public Login dupcheck(Login li) {
		
		return ss.selectOne("Login.selectLogin",li);
	}

	@Override
	public Login fhrmdlstlfvo(Login li) {
		return ss.selectOne("Login.selectLogin",li);
	}
	

}
package com.bdi.sp.service.Impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
	public Map<String,String> insertLogin(Login li) {
		Map<String,String> rMap = new HashMap<String,String>();
		rMap.put("success","fail");
		rMap.put("msg", "회원가입이 정상적으로 되지 않았습니다.");
		
		if(ldao.insertLogin(li)==1) {
			rMap.put("success","success");
			rMap.put("msg", "회원가입이 완료되었습니다.");
			return rMap;
		}
		return rMap;
	}

	@Override
	public Map<String,String> updateLogin(Login li) {
		Map<String,String> rMap = new HashMap<String,String>();
		rMap.put("success","fail");
		rMap.put("msg", "수정이 안됬 ");
				
		if(ldao.insertLogin(li)==1) {
			
			rMap.put("success","success");
			rMap.put("msg", "수정되었 ");
			
		}
		return rMap;
		
	}

	@Override
	public int deleteLogin(int linum) {
		return ldao.deleteLogin(linum);
	}

	@Override
	public Map<String, String> wndqhrcpzm(Login li) {

		Map<String,String> rMap = new HashMap<String,String>();
		rMap.put("success","success");
		rMap.put("msg", "중복아닙니다 ");
				
		if(ldao.dupcheck(li)!=null) {
			
			rMap.put("success","fail");
			rMap.put("msg", "중복입니다 ");
			
		}
		return rMap;
	}

	@Override
	public Map<String, String> loginCheck(Login li) {
		Map<String,String> rMap = new HashMap<String,String>();
		rMap.put("hoyoung","tlfvo");
		rMap.put("msg", "로그인실패");
		if(ldao.fhrmdlstlfvo(li)!=null) {
			rMap.put("hoyoung","tjdrhd");
			rMap.put("msg", "로그인이성공하였습니다");
		}
		return rMap;
	}

}

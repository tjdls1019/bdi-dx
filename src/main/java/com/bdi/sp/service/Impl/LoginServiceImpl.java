package com.bdi.sp.service.Impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
		//여기서 수정과 로그인을 담당하게 한다. 그러면 텍스트 박스가 조금 달라지겟져? 이때 뭘주냐 안
		Map<String,String> rMap = new HashMap<String,String>();
		rMap.put("success","fail");
		rMap.put("msg", "응 아냐");
				
		if(ldao.updateLogin(li)==1) {
			
			rMap.put("success","success");
			rMap.put("msg", "응 수정 ");
			
		}
		return rMap;
		
	}

	@Override
	public Map<String, String> deleteLogin(int linum) {
		Map<String,String> rMap = new HashMap<String,String>();
		rMap.put("success","fail");
		rMap.put("msg", "요청하신 처리는 ..실패 ");
				
		if(ldao.deleteLogin(linum)==1) {
			//이거 숫자 1이 뭔줄 알아냈어요. 쿼리문 성공한 문장 갯수. 
			rMap.put("success","success");
			rMap.put("msg", "삭제되었습니다. ");
			
		}
		return rMap;
		
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
	public Map<String, String> loginCheck(Login li,HttpServletRequest req) {
		Map<String,String> rMap = new HashMap<String,String>();
		HttpSession hs= req.getSession();
		hs.setAttribute("token","no");
		
		rMap.put("hoyoung","tlfvo");
		rMap.put("msg", "로그인실패");
		if(ldao.fhrmdlstlfvo(li)!=null) {
			hs.setAttribute("token","yes");//이게 한글이 안되는거같아요.. 
			hs.setAttribute("ssuser",ldao.fhrmdlstlfvo(li)); //여기서 넘길때 이걸주면안대구.li는 내가 전해준 거구. 저긴거는 전체정보.
			rMap.put("hoyoung","tjdrhd");
			rMap.put("msg", "로그인이성공하였습니다");
		}
		return rMap;
	}

}
package com.bdi.sp.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bdi.sp.dao.DepartDAO;
import com.bdi.sp.service.DepartService;
import com.bdi.sp.vo.Depart;

@Service
public class DepartServiceImpl implements DepartService {

	@Autowired
	private DepartDAO ddao;
	
	@Override
	public List<Depart> getDepartList(Depart d) {
		// TODO Auto-generated method stub
		return ddao.getDepartList(d);
	}

	@Override
	public Depart getDepart(int dino) {
		// TODO Auto-generated method stub
		return ddao.getDepart(dino);
	}

	@Override
	public int insertDepart(Depart d) {
		// TODO Auto-generated method stub
		return ddao.insertDepart(d);
	}

	@Override
	public int updateDepart(Depart d) {
		// TODO Auto-generated method stub
		return ddao.updateDepart(d);
	}

	@Override
	public int deleteDepart(int dino) {
		// TODO Auto-generated method stub
		return ddao.deleteDepart(dino);
	}

}

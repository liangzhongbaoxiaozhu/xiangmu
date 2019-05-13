package com.lzb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lzb.dao.Rolesdao;
import com.lzb.entity.FenYe;
import com.lzb.entity.Roles;
@Service
public class RolesServiceImpl implements RolesService{

	@Autowired
	private Rolesdao rolesdao;
	@Override
	public FenYe SelectRoles(FenYe fen) {
		// TODO Auto-generated method stub
		List<Roles> selectRoles = rolesdao.SelectRoles(fen);
		fen.setRows(selectRoles);
		Integer selectCount = rolesdao.SelectCount(fen);
		fen.setPageSize(selectCount);
		return fen;
	}
	@Override
	public Integer InsertRoles(Roles roles) {
		// TODO Auto-generated method stub
		return rolesdao.InsertRoles(roles);
	}
	@Override
	public Integer UpdateRoles(Roles roles) {
		// TODO Auto-generated method stub
		return rolesdao.UpdateRoles(roles);
	}
	@Override
	public Integer deleteRoles(Integer id) {
		// TODO Auto-generated method stub
		return rolesdao.deleteRoles(id);
	}

}

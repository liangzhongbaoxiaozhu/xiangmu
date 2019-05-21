package com.lzb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import com.lzb.dao.Usersdao;
import com.lzb.entity.FenYe;
import com.lzb.entity.Roles;
import com.lzb.entity.Users;

@Component
public class UsersServiceImpl implements UsersService{

	@Autowired
	private Usersdao usersdao;
	@Override
	public Users DengLu(Users user) {
		// TODO Auto-generated method stub
		return usersdao.DengLu(user);
	}
	@Override
	public FenYe SelectUsers(FenYe fen) {
		// TODO Auto-generated method stub
		Integer selectCount = usersdao.SelectCount(fen);
		List<Users> selectUsers = null;
		if(fen.getPaixu()==null){
			selectUsers= usersdao.SelectUsers(fen);
		}else{
			if(fen.getPaixu()==0){
				selectUsers=usersdao.SelectUsersCuanJian(fen);
			}
			if(fen.getPaixu()==1){
				selectUsers=usersdao.SelectUserszuihou(fen);
			}
		}
		
		fen.setTotal(selectCount);
		fen.setRows(selectUsers);
		return fen;
	}
	@Override
	public Integer InsertUsers(Users users) {
		// TODO Auto-generated method stub
		Integer selectName = usersdao.SelectName(users.getLoginName());
        if(selectName>0){
        	return 0;
        }else{
        	return usersdao.InsertUsers(users);	
        }
		
	}
	@Override
	public Integer deleteUsers(Integer id) {
		// TODO Auto-generated method stub
		return usersdao.deleteUsers(id);
	}
	@Override
	public Integer isShuoDing(Integer id) {
		// TODO Auto-generated method stub
		return usersdao.isShuoDing(id);
	}
	@Override
	public Integer noShuoDing(Integer id) {
		// TODO Auto-generated method stub
		return usersdao.noShuoDing(id);
	}
	@Override
	public FenYe SelectRolesUsers(Integer id) {
		// TODO Auto-generated method stub
		List<Roles> selectRolesUsers = usersdao.SelectRolesUsers(id);
		FenYe fen=new FenYe();
		fen.setRows(selectRolesUsers);
		return fen;
	}
	@Override
	public FenYe SelectRoles() {
		// TODO Auto-generated method stub
		List<Roles> selectRoles = usersdao.SelectRoles();
		FenYe fen=new FenYe();
		fen.setRows(selectRoles);
		return fen;
	}
	@Override
	public Integer InsertUserRoles(Integer UserId, Integer RoleId) {
		// TODO Auto-generated method stub
		FenYe fen=new FenYe();
		fen.setPage(UserId);
		fen.setPageSize(RoleId);
		return usersdao.InsertUserRoles(fen);
	}
	@Override
	public Integer deleteUserRoles(Integer UserId, Integer RoleId) {
		// TODO Auto-generated method stub
		FenYe fen=new FenYe();
		fen.setPage(UserId);
		fen.setPageSize(RoleId);
		return usersdao.deleteUserRoles(fen);
	}
	@Override
	public Integer SelectCountUsers(Integer UserId, Integer RoleId) {
		// TODO Auto-generated method stub
		FenYe fen=new FenYe();
		fen.setPage(UserId);
		fen.setPageSize(RoleId);
		Integer selectCountUsers = usersdao.SelectCountUsers(fen);
		return selectCountUsers;
	}
	@Override
	public Integer updateUsers(Users users) {
		// TODO Auto-generated method stub
		return usersdao.updateUsers(users);
	}
	@Override
	public Integer updateMiMa(Integer id) {
		// TODO Auto-generated method stub
		return usersdao.updateMiMa(id);
	}
	@Override
	public FenYe SelectGeRen(Integer uid) {
		// TODO Auto-generated method stub
		List<Users> selectGeRen = usersdao.SelectGeRen(uid);
		FenYe fen=new FenYe();
		fen.setRows(selectGeRen);
		return fen;
	}
	@Override
	public Integer QianDao(Users user) {
		// TODO Auto-generated method stub
		return usersdao.QianDao(user);
	}
	//ÐÞ¸Ä¸öÈËÃÜÂë
	@Override
	public Integer UpdateGeRenMiMa(Users user) {
		// TODO Auto-generated method stub
		Integer updateGeRenMiMa = usersdao.UpdateGeRenMiMa(user);
		return updateGeRenMiMa;
	}
	@Override
	public FenYe SelectQianDao(FenYe fen) {
		// TODO Auto-generated method stub
		Integer selectQianDaoCount = usersdao.SelectQianDaoCount(fen);
		List<Users> selectQianDao = usersdao.SelectQianDao(fen);
		fen.setTotal(selectQianDaoCount);
		fen.setRows(selectQianDao);
		return fen;
	}
	@Override
	public Integer SelectQianTui(Integer uid) {
		// TODO Auto-generated method stub
		return usersdao.SelectQianTui(uid);
	}
	@Override
	public Integer updateQuanZhong(Users user) {
		// TODO Auto-generated method stub
		return usersdao.updateQuanZhong(user);
	}
	@Override
	public Integer updateZiDongFenPei() {
		// TODO Auto-generated method stub
		return usersdao.updateZiDongFenPei();
	}
	@Override
	public Integer updateguanbiZiDong() {
		// TODO Auto-generated method stub
		return usersdao.updateguanbiZiDong();
	}
	@Override
	public String SelectZiDongFenPei() {
		// TODO Auto-generated method stub
		return usersdao.SelectZiDongFenPei();
	}

}

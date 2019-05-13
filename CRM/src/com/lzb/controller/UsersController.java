package com.lzb.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lzb.entity.FenYe;
import com.lzb.entity.Modules;
import com.lzb.entity.Users;
import com.lzb.service.UsersService;

@Controller
public class UsersController {

	@Autowired
	private UsersService usersService;
	
	
	
	@RequestMapping(value="/SelectUsers",method=RequestMethod.POST)
	@ResponseBody
	public FenYe SelectUsers(Integer page,Integer rows){
		FenYe fen=new FenYe();
		fen.setPage((page-1)*rows);
		fen.setPageSize(rows);
		fen = usersService.SelectUsers(fen);
		return fen;
	}
	@RequestMapping(value="/InsertUsers",method=RequestMethod.POST)
	@ResponseBody
	public Integer InsertUsers(Users users){
		Integer insertRoles = usersService.InsertUsers(users);
		return insertRoles;
	}
	
	
	@RequestMapping(value="/DeleteUsers",method=RequestMethod.POST)
	@ResponseBody
	public Integer DeleteUsers(Integer id){
		Integer deleteRoles = usersService.deleteUsers(id);
		return deleteRoles;
	}
	
	@RequestMapping(value="/isShuoDing",method=RequestMethod.POST)
	@ResponseBody
	public Integer isShuoDing(Integer id){
		Integer updateRoles = usersService.isShuoDing(id);
		return updateRoles;
	}
	@RequestMapping(value="/noShuoDing",method=RequestMethod.POST)
	@ResponseBody
	public Integer noShuoDing(Integer id){
		Integer updateRoles = usersService.noShuoDing(id);
		return updateRoles;
	}
	//根据用户id查询角色
	@RequestMapping(value="/SelectRolesUsers",method=RequestMethod.POST)
	@ResponseBody
	public FenYe SelectRolesUsers(Integer id){
		FenYe selectRolesUsers = usersService.SelectRolesUsers(id);
		return selectRolesUsers;
	}
	//查询所有角色
	@RequestMapping(value="/SelectURoles",method=RequestMethod.POST)
	@ResponseBody
	public FenYe SelectURoles(){
		FenYe selectRoles = usersService.SelectRoles();
		return selectRoles;
	}
	//增加用户角色
	@RequestMapping(value="/InsertUserRoles",method=RequestMethod.POST)
	@ResponseBody
	public Integer InsertUserRoles(Integer userId, Integer roleId){
		Integer insertUserRoles = usersService.InsertUserRoles(userId, roleId);
		return insertUserRoles;
	}

	//删除用户角色
	@RequestMapping(value="/deleteUserRoles",method=RequestMethod.POST)
	@ResponseBody
	public Integer deleteUserRoles(Integer uRrid){
		Integer deleteUserRoles = usersService.deleteUserRoles(uRrid);
		return deleteUserRoles;
	}
}

package com.lzb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lzb.entity.FenYe;
import com.lzb.entity.Roles;
import com.lzb.service.RolesService;

@Controller
public class RolesController {

	@Autowired
	private RolesService rolesService;
	
	@RequestMapping(value="/SelectRoles",method=RequestMethod.POST)
	@ResponseBody
	public FenYe SelectRoles(Integer page,Integer rows){
		FenYe fen=new FenYe();
		fen.setPage((page-1)*rows);
		fen.setPageSize(rows);
		fen = rolesService.SelectRoles(fen);
		return fen;
	}
	@RequestMapping(value="/InsertRoles",method=RequestMethod.POST)
	@ResponseBody
	public Integer InsertRoles(Roles roles){
		Integer insertRoles = rolesService.InsertRoles(roles);
		return insertRoles;
	}
	
	@RequestMapping(value="/UpdateRoles",method=RequestMethod.POST)
	@ResponseBody
	public Integer UpdateRoles(Roles roles){
		Integer updateRoles = rolesService.UpdateRoles(roles);
		return updateRoles;
	}
	@RequestMapping(value="/DeleteRoles",method=RequestMethod.POST)
	@ResponseBody
	public Integer DeleteRoles(Integer id){
		Integer deleteRoles = rolesService.deleteRoles(id);
		return deleteRoles;
	}
}

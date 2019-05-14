package com.lzb.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lzb.entity.FenYe;
import com.lzb.entity.Modules;
import com.lzb.entity.Roles;
import com.lzb.service.ModulesService;

@Controller
public class ModulesController {
	@Autowired
	private ModulesService modulesService;
	
	@RequestMapping(value="/SelectModul",method={RequestMethod.POST},produces = "text/plain;charset=utf-8")
	@ResponseBody
	public String SelectModul(int id,HttpServletRequest request){
		
		String selectRoles = modulesService.SelectRoles(id,request);
		/*System.out.println(selectRoles);*/
		return selectRoles;
	}
	
	
	
	@RequestMapping(value="/SelectModules",method=RequestMethod.POST)
	@ResponseBody
	public FenYe SelectModules(Integer page,Integer rows){
		FenYe fen=new FenYe();
		fen.setPage((page-1)*rows);
		fen.setPageSize(rows);
		fen = modulesService.SelectModuless(fen);
		return fen;
	}
	@RequestMapping(value="/InsertModules",method=RequestMethod.POST)
	@ResponseBody
	public Integer InsertModules(Modules modules){
		Integer insertRoles = modulesService.InsertModules(modules);
		return insertRoles;
	}
	
	@RequestMapping(value="/UpdateModules",method=RequestMethod.POST)
	@ResponseBody
	public Integer UpdateModules(Modules modules){
		Integer updateRoles = modulesService.UpdateModules(modules);
		return updateRoles;
	}
	@RequestMapping(value="/DeleteModules",method=RequestMethod.POST)
	@ResponseBody
	public Integer DeleteModules(Integer id){
		Integer deleteRoles = modulesService.deleteModules(id);
		return deleteRoles;
	}
	

}

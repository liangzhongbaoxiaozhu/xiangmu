package com.lzb.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

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

}

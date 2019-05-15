package com.lzb.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.lzb.entity.FenYe;
import com.lzb.entity.Modules;
import com.lzb.entity.Roles;
import com.lzb.entity.TreeNode;
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

	@RequestMapping(value="/SelectShu",method=RequestMethod.POST,produces = "text/plain;charset=utf-8")
	@ResponseBody
	public String SelectShu(Integer id){
		TreeNode node=new TreeNode();
		List<Modules> Fuid2 = rolesService.SelectModulesFuid2();
		String chucuen=null;
		for(Modules m:Fuid2){
			TreeNode selectModulesFuid = rolesService.SelectModulesFuid(m.getMid(),id);
			String jsonText = JSON.toJSONString(selectModulesFuid, true); 
			/*System.out.println(jsonText);*/
			if(chucuen==null){
				chucuen=jsonText;
			}else{
				chucuen=chucuen+","+jsonText;
			}
		}
		chucuen="["+chucuen+"]";
		/*System.out.println(chucuen);*/
		return chucuen;
	}
	
	
	@RequestMapping(value="/InsertRoleModule",method=RequestMethod.POST)
	@ResponseBody
	public Integer InsertRoleModule(String Mid,Integer Rid){
		Integer deleteRolesModules = rolesService.DeleteRolesModules(Rid);
		String mid=Mid.toString();
		String[] list=mid.split(",");
		for(String lis:list){
			/*System.out.println(lis);*/
			Integer lis2=null;
			if(lis!=""){
				lis2=Integer.parseInt(lis);
			}
				FenYe fen=new FenYe();
				fen.setPage(lis2);
				fen.setPageSize(Rid);
				Integer integerRolesModules = rolesService.IntegerRolesModules(fen);
				if(integerRolesModules<1){
					return integerRolesModules;
				
			}
		
		}
		return 1;
	}
}

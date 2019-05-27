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
import com.lzb.service.ModulesService;

@Controller
public class ModulesController {
	@Autowired
	private ModulesService modulesService;
	
	@RequestMapping(value="/SelectModul",method={RequestMethod.POST},produces = "text/plain;charset=utf-8")
	@ResponseBody
	public String SelectModul(Integer uid){
		
		TreeNode node=new TreeNode();
		List<Modules> Fuid = modulesService.SelectFuidMoKuai();
		String chucuen=null;
		for(Modules m:Fuid){
			TreeNode selectModulesFuid = modulesService.SelectCaiDan(m.getMid(),uid);
			/*System.out.println(selectModulesFuid.getChildren());*/
			String jsonText="";
			if(selectModulesFuid.getChildren().toString()!="[]"){
				 jsonText = JSON.toJSONString(selectModulesFuid, true); 
			}
			
			/*System.out.println(jsonText);*/
			if(chucuen==null&&jsonText!=""){
				chucuen=jsonText;
			}else{
				if(jsonText!=""){
					chucuen=chucuen+","+jsonText;
				}
			}
		}
		chucuen="["+chucuen+"]";
		/*System.out.println(chucuen);*/
		return chucuen;
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
	
	
	@RequestMapping(value="/SelectMoKuaiShu",method=RequestMethod.POST,produces = "text/plain;charset=utf-8")
	@ResponseBody
	public String SelectMoKuaiShu(){
		TreeNode node=new TreeNode();
		List<Modules> Fuid = modulesService.SelectFuidMoKuai();
		String chucuen=null;
		for(Modules m:Fuid){
			TreeNode selectModulesFuid = modulesService.SelectFuChaZiMoKuai(m.getMid());
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

}

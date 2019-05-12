package com.lzb.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import jdk.nashorn.internal.ir.RuntimeNode.Request;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lzb.dao.Modulesdao;
import com.lzb.entity.Modules;
import com.lzb.entity.Roles;
@Component
public class ModulesServiceImpl implements ModulesService{

	@Autowired
	private Modulesdao modulesdao;
	@Override
	public String SelectRoles(Integer id,HttpServletRequest request) {
		// TODO Auto-generated method stub
		String all="";
		String beiyong="";
		List<Roles> selectRoles = modulesdao.SelectRoles(id);
		
		
		for(int i=0;i<selectRoles.size();i++){
			List<Modules> selectModules = modulesdao.SelectModules(selectRoles.get(i).getRid());
			request.getSession().setAttribute("shu", selectModules.size());
			for(int j=0;j<selectModules.size();j++){
				beiyong=beiyong+"<ul id='treeUlId"+(j+1)+"' class='easyui-tree'><li><span><a title='"+selectModules.get(j).getMid()+"' onclick='navTab(\""+selectModules.get(j).getMname()+"\",\""+selectModules.get(j).getPath()+"\")'>"+selectModules.get(j).getMname()+"</a></span><ul>";
				List<Modules> selectZiModules = modulesdao.SelectZiModules(selectModules.get(j).getMid());
				for(int z=0;z<selectZiModules.size();z++){
					beiyong=beiyong+"<li><span><a title="+selectZiModules.get(z).getMid()+" onclick='navTab(\""+selectZiModules.get(z).getMname()+"\",\""+selectZiModules.get(z).getPath()+"\")'>"+selectZiModules.get(z).getMname()+"</a></span></li>";
				}
				beiyong=beiyong+"</ul></li></ul>";
			}
			if(all!=null){
				all=all+beiyong;
			}else{
				all=beiyong;
			}
			
		}
		System.out.println(all);
		return all;
	}

}

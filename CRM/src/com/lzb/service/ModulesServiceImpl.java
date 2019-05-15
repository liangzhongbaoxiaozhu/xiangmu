package com.lzb.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import jdk.nashorn.internal.ir.RuntimeNode.Request;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lzb.dao.Modulesdao;
import com.lzb.entity.FenYe;
import com.lzb.entity.Modules;
import com.lzb.entity.Roles;
import com.lzb.entity.TreeNode;
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
	@Override
	public FenYe SelectModuless(FenYe fen) {
		// TODO Auto-generated method stub
		Integer selectCount = modulesdao.SelectCount(fen);
		List<Roles> selectModules = modulesdao.SelectModuless(fen);
		fen.setTotal(selectCount);
		fen.setRows(selectModules);
		return fen;
	}
	@Override
	public Integer InsertModules(Modules modules) {
		// TODO Auto-generated method stub
		return modulesdao.InsertModules(modules);
	}
	@Override
	public Integer UpdateModules(Modules modules) {
		// TODO Auto-generated method stub
		return modulesdao.UpdateModules(modules);
	}
	@Override
	public Integer deleteModules(Integer id) {
		// TODO Auto-generated method stub
		return modulesdao.deleteModules(id);
	}
	@Override
	public List<Modules> SelectFuidMoKuai() {
		// TODO Auto-generated method stub
		List<Modules> selectFuidMoKuai = modulesdao.SelectFuidMoKuai();
		return selectFuidMoKuai;
	}
	@Override
	public TreeNode SelectFuChaZiMoKuai(Integer id) {
		// TODO Auto-generated method stub
		
		Modules Module = modulesdao.SelectChaZiMoKuai(id);
		//封装
		TreeNode nod=new TreeNode();
		nod.setId(Module.getMid().toString());
		nod.setText(Module.getMname());
		nod.setParentid(""+Module.getParentId()+"");
		Map<String, Object> attributes = new HashMap<String, Object>();
		 attributes.put("url",Module.getPath());
		nod.setAttributes(attributes);
		//查询子
		List<Modules> Zi = modulesdao.SelectFuChaZiMoKuai(Module.getMid());
		 List<TreeNode> arrList = new ArrayList<TreeNode>();
		for(Modules yi:Zi){
			/*System.out.println(yi.getMid());*/
			TreeNode nod2=new TreeNode();
			nod2.setId(yi.getMid().toString());
			nod2.setText(yi.getMname());
			nod2.setParentid(yi.getParentId().toString());
			Map<String, Object> attributes2 = new HashMap<String, Object>();
			 attributes.put("url",yi.getPath());
			nod2.setAttributes(attributes);
			
			arrList.add(nod2);
		}
		for (TreeNode child :arrList) {
            TreeNode n = SelectDiGui(Integer.parseInt(child.getId())); // 递归(查询所有的子模块)
            nod.getChildren().add(child);
        }
	            return nod;
	}
	
	//用来递归
	public TreeNode SelectDiGui(Integer id) {
		// TODO Auto-generated method stub
		
		Modules Module = modulesdao.SelectChaZiMoKuai(id);
		//封装
		TreeNode nod=new TreeNode();
		nod.setId(Module.getMid().toString());
		nod.setText(Module.getMname());
		nod.setParentid(""+Module.getParentId()+"");
		Map<String, Object> attributes = new HashMap<String, Object>();
		 attributes.put("url",Module.getPath());
		nod.setAttributes(attributes);
		//查询子
		List<Modules> Zi = modulesdao.SelectFuChaZiMoKuai(Module.getMid());
		 List<TreeNode> arrList = new ArrayList<TreeNode>();
		for(Modules yi:Zi){
			/*System.out.println(yi.getMid());*/
			TreeNode nod2=new TreeNode();
			nod2.setId(yi.getMid().toString());
			nod2.setText(yi.getMname());
			nod2.setParentid(yi.getParentId().toString());
			Map<String, Object> attributes2 = new HashMap<String, Object>();
			 attributes.put("url",yi.getPath());
			nod2.setAttributes(attributes);
			
			arrList.add(nod2);
		}
		for (TreeNode child :arrList) {
            TreeNode n = SelectDiGui(Integer.parseInt(child.getId())); // 递归(查询所有的子模块)
            nod.getChildren().add(child);
        }
	            return nod;
	}

}

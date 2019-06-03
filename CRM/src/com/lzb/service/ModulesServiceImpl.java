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
import com.lzb.dao.Rolesdao;
import com.lzb.entity.FenYe;
import com.lzb.entity.Modules;
import com.lzb.entity.Roles;
import com.lzb.entity.TreeNode;
@Component
public class ModulesServiceImpl implements ModulesService{

	@Autowired
	private Modulesdao modulesdao;
	@Autowired
	private Rolesdao rolesdao;
	@Override
	public TreeNode SelectCaiDan(Integer id,Integer uid) {
		// TODO Auto-generated method stub
		//调用角色表的dao
		List<Modules> selectRolesModulesid = rolesdao.SelectRolesModulesid(uid);
		
		Modules Module = modulesdao.SelectChaZiMoKuai(id);
		
		//封装
		TreeNode nod=new TreeNode();
		nod.setId(Module.getMid().toString());
		nod.setText(Module.getMname());
		nod.setParentid(""+Module.getParentId()+"");
		Map<String, Object> attributes = new HashMap<String, Object>();
		 attributes.put("url",Module.getPath());
		 attributes.put("weight",Module.getWeight());
		nod.setAttributes(attributes);
		//查询子
		List<Modules> Zi = modulesdao.SelectFuChaZiMoKuai(Module.getMid());
		
		 List<TreeNode> arrList = new ArrayList<TreeNode>();
		for(Modules yi:Zi){
			
			TreeNode nod2=new TreeNode();
			nod2.setId(yi.getMid().toString());
			nod2.setText(yi.getMname());
			nod2.setParentid(yi.getParentId().toString());
			Map<String, Object> attributes2 = new HashMap<String, Object>();
			 attributes2.put("url",yi.getPath());
			 attributes2.put("weight",yi.getWeight());
			nod2.setAttributes(attributes2);
			for(Modules s:selectRolesModulesid){
				/*System.out.println(s.getMid());*/
				if(s.getMid()==yi.getMid()){
					arrList.add(nod2);
					break;
				}
			}
			
		}
		for (TreeNode child :arrList) {
            TreeNode n = SelectDiGuiCaiDan(Integer.parseInt(child.getId()),uid,child.isChecked()); // 递归(查询所有的子模块)
            nod.getChildren().add(n);
        }
	            return nod;
	}
	
	//用来递归
			public TreeNode SelectDiGuiCaiDan(Integer id,Integer uid,boolean banduan) {
				// TODO Auto-generated method stub
				
				List<Modules> selectRolesModulesid = rolesdao.SelectRolesModulesid(uid);
				
				Modules Module = rolesdao.SelectModule(id);
				//封装
				TreeNode nod=new TreeNode();
				nod.setId(Module.getMid().toString());
				nod.setText(Module.getMname());
				nod.setParentid(""+Module.getParentId()+"");
				Map<String, Object> attributes = new HashMap<String, Object>();
				 attributes.put("url",Module.getPath());
				 attributes.put("weight",Module.getWeight());
				nod.setAttributes(attributes);
				nod.setChecked(banduan);
				//查询子
				List<Modules> Zi = rolesdao.SelectZiModules2(Module.getMid());
				 List<TreeNode> arrList = new ArrayList<TreeNode>();
				for(Modules yi:Zi){
					/*System.out.println(yi.getMid());*/
					TreeNode nod2=new TreeNode();
					nod2.setId(yi.getMid().toString());
					nod2.setText(yi.getMname());
					nod2.setParentid(yi.getParentId().toString());
					Map<String, Object> attributes2 = new HashMap<String, Object>();
					 attributes2.put("url",yi.getPath());
					 attributes2.put("weight",yi.getWeight());
					nod2.setAttributes(attributes2);
					
					for(Modules s:selectRolesModulesid){
						//System.out.println(s.getMid());
						if(s.getMid()==yi.getMid()){
							arrList.add(nod2);
							break;
						}
					}
					
				}
				for (TreeNode child :arrList) {
					/*System.out.println(child.getId()+","+child.isChecked()+","+uid);*/
		            TreeNode n = SelectDiGuiCaiDan(Integer.parseInt(child.getId()),uid,child.isChecked()); // 递归(查询所有的子模块)
		            nod.getChildren().add(n);
		        }
				
			return nod;
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
		List<Modules> selectMiZi = modulesdao.SelectMiZi(modules.getMname());
		if(selectMiZi.size()>0){
			return 2;
		}
		return modulesdao.InsertModules(modules);
	}
	@Override
	public Integer UpdateModules(Modules modules) {
		// TODO Auto-generated method stub
		List<Modules> selectMiZi = modulesdao.SelectMiZi(modules.getMname());
		if(selectMiZi.size()>0){
			return 2;
		}
		return modulesdao.UpdateModules(modules);
	}
	@Override
	public Integer deleteModules(Integer id) {
		// TODO Auto-generated method stub
		List<Modules> selectMoKuai = modulesdao.SelectRMoKuai(id);
		/*System.out.println(selectMoKuai);*/
		if(selectMoKuai!=null){
			if(selectMoKuai.toString()=="[]"){
				
			}else{
				return 2;
			}
		}
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
		 attributes.put("weight",Module.getWeight());
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
			 attributes2.put("url",yi.getPath());
			 attributes2.put("weight",yi.getWeight());
			nod2.setAttributes(attributes2);
			
			arrList.add(nod2);
		}
		for (TreeNode child :arrList) {
            TreeNode n = SelectDiGui(Integer.parseInt(child.getId())); // 递归(查询所有的子模块)
            nod.getChildren().add(n);
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
		 attributes.put("weight",Module.getWeight());
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
			 attributes2.put("url",yi.getPath());
			 attributes2.put("weight",yi.getWeight());
			nod2.setAttributes(attributes2);
			
			arrList.add(nod2);
		}
		for (TreeNode child :arrList) {
            TreeNode n = SelectDiGui(Integer.parseInt(child.getId())); // 递归(查询所有的子模块)
            nod.getChildren().add(n);
        }
	            return nod;
	}

	@Override
	public Integer IntegerFuLei(Modules modules) {
		// TODO Auto-generated method stub
		List<Modules> selectMiZi = modulesdao.SelectMiZi(modules.getMname());
		if(selectMiZi.size()>0){
			return 2;
		}
		return modulesdao.IntegerFuMoKuai(modules);
	}

}

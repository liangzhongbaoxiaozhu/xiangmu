package com.lzb.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lzb.dao.Rolesdao;
import com.lzb.entity.FenYe;
import com.lzb.entity.Modules;
import com.lzb.entity.Roles;
import com.lzb.entity.TreeNode;
@Service
public class RolesServiceImpl implements RolesService{

	@Autowired
	private Rolesdao rolesdao;
	@Override
	public FenYe SelectRoles(FenYe fen) {
		// TODO Auto-generated method stub
		List<Roles> selectRoles = rolesdao.SelectRoles(fen);
		fen.setRows(selectRoles);
		Integer selectCount = rolesdao.SelectCount(fen);
		fen.setTotal(selectCount);
		return fen;
	}
	@Override
	public Integer InsertRoles(Roles roles) {
		// TODO Auto-generated method stub
		Roles selectMingZi = rolesdao.selectMingZi(roles.getRname());
		if(selectMingZi!=null){
			return 2;
		}
		return rolesdao.InsertRoles(roles);
	}
	@Override
	public Integer UpdateRoles(Roles roles) {
		// TODO Auto-generated method stub
		Roles selectMingZi = rolesdao.selectMingZi(roles.getRname());
		if(selectMingZi!=null){
			return 2;
		}
		return rolesdao.UpdateRoles(roles);
	}
	@Override
	public String deleteRoles(Integer id) {
		// TODO Auto-generated method stub
		Integer selectRoleModulesCount = rolesdao.selectRoleModulesCount(id);
		String jieguo="失败";
		if(selectRoleModulesCount==0){
			Integer deleteRoles = rolesdao.deleteRoles(id);
			if(deleteRoles>0){
				jieguo="成功";
			}
		}else{
			jieguo=jieguo+",该角色拥有权限不能删除";
		}
		return jieguo;
	}
	
	//根据父id查询子id
	@Override
	public TreeNode SelectModulesFuid(Integer id,Integer rid) {
		// TODO Auto-generated method stub
		
		List<Modules> selectRolesModulesid = rolesdao.SelectRolesZhuangYong(rid);
		/*for(Modules ss:selectRolesModulesid){
			System.out.println(ss.getMid());
		}*/
		
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
					if(s.getMid()==yi.getMid()){
						nod2.setChecked(true);
						break;
					}
				}
				arrList.add(nod2);
			}
			for (TreeNode child :arrList) {
	            TreeNode n = SelectDiGui(Integer.parseInt(child.getId()),rid,child.isChecked()); // 递归(查询所有的子模块)
	            nod.getChildren().add(n);
	        }
			
		return nod;
	}
	
	//用来递归
		public TreeNode SelectDiGui(Integer id,Integer rid,boolean banduan) {
			// TODO Auto-generated method stub
			
			List<Modules> selectRolesModulesid = rolesdao.SelectRolesZhuangYong(rid);
			
			
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
						nod2.setChecked(true);
						break;
					}
				}
				arrList.add(nod2);
			}
			for (TreeNode child :arrList) {
				/*System.out.println(child.getId()+","+child.isChecked()+","+uid);*/
	            TreeNode n = SelectDiGui(Integer.parseInt(child.getId()),rid,child.isChecked()); // 递归(查询所有的子模块)
	            nod.getChildren().add(n);
	        }
			
		return nod;
		}
	
	
	
	//查询父id
	@Override
	public List<Modules> SelectModulesFuid2() {
		// TODO Auto-generated method stub
		List<Modules> selectModulesFuid = rolesdao.SelectModulesFuid();
		
		return selectModulesFuid;
	}
	@Override
	public Integer IntegerRolesModules(FenYe fen) {
		// TODO Auto-generated method stub
		Integer integerRolesModules = rolesdao.IntegerRolesModules(fen);
		return integerRolesModules;
	}
	@Override
	public Integer DeleteRolesModules(Integer id) {
		// TODO Auto-generated method stub
		Integer deleteRolesModules = rolesdao.DeleteRolesModules(id);
		return deleteRolesModules;
	}
	

}

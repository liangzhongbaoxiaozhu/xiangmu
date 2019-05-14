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
		fen.setPageSize(selectCount);
		return fen;
	}
	@Override
	public Integer InsertRoles(Roles roles) {
		// TODO Auto-generated method stub
		return rolesdao.InsertRoles(roles);
	}
	@Override
	public Integer UpdateRoles(Roles roles) {
		// TODO Auto-generated method stub
		return rolesdao.UpdateRoles(roles);
	}
	@Override
	public Integer deleteRoles(Integer id) {
		// TODO Auto-generated method stub
		return rolesdao.deleteRoles(id);
	}
	
	@Override
	public TreeNode SelectModulesFuid(Integer id,Integer uid) {
		// TODO Auto-generated method stub
		
			
		List<Modules> selectRolesModulesid = rolesdao.SelectRolesModulesid(uid);
		
		
			Modules Module = rolesdao.SelectModule(id);
			//��װ
			TreeNode nod=new TreeNode();
			nod.setId(Module.getMid().toString());
			nod.setText(Module.getMname());
			nod.setParentid(""+Module.getParentId()+"");
			Map<String, Object> attributes = new HashMap<String, Object>();
			 attributes.put("url",Module.getPath());
			nod.setAttributes(attributes);
			//��ѯ��
			List<Modules> Zi = rolesdao.SelectZiModules2(Module.getMid());
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
				
				for(Modules s:selectRolesModulesid){
					if(s.getMid()==yi.getMid()){
						nod2.setChecked(true);
						break;
					}
				}
				arrList.add(nod2);
			}
			for (TreeNode child :arrList) {
	            /*TreeNode n = SelectModulesFuid(child.getId()); // �ݹ�(��ѯ���е���ģ��)
*/	            nod.getChildren().add(child);
	        }
		return nod;
	}
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

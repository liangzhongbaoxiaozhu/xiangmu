package com.lzb.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.lzb.entity.FenYe;
import com.lzb.entity.Modules;
import com.lzb.entity.Roles;
import com.lzb.entity.TreeNode;

public interface RolesService {

	//查询所有
	FenYe SelectRoles(FenYe fen);
	
	//新增
	Integer InsertRoles(Roles roles);
	
	//修改
	Integer UpdateRoles(Roles roles);
	
	//删除
	String deleteRoles(Integer id);
	
	//查询所有父id
	TreeNode SelectModulesFuid(Integer id,Integer uid);
	
	//查询所有父id
	List<Modules> SelectModulesFuid2();
	
    //新增角色模块
	Integer IntegerRolesModules(FenYe fen);
	
	//删除有关的角色模块
	Integer DeleteRolesModules(Integer id);
}

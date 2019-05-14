package com.lzb.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.lzb.entity.FenYe;
import com.lzb.entity.Modules;
import com.lzb.entity.Roles;
import com.lzb.entity.TreeNode;

public interface RolesService {

	/**
	 * 查询所有
	 * @param fen
	 * @return
	 */
	FenYe SelectRoles(FenYe fen);
	/**
	 * 新增
	 * @param roles
	 * @return
	 */
	Integer InsertRoles(Roles roles);
	/**
	 * 修改
	 * @param roles
	 * @return
	 */
	Integer UpdateRoles(Roles roles);
	
	/**
	 * 删除
	 * @param id
	 * @return
	 */
	Integer deleteRoles(Integer id);
	
	/**
	 * 查询所有父id
	 * @return
	 */
	TreeNode SelectModulesFuid(Integer id,Integer uid);
	/**
	 * 查询所有父id
	 * @return
	 */
	List<Modules> SelectModulesFuid2();
	/*根据父模块id查子模块id*/
	/*List<Modules> SelectZiModules2(Integer id);*/
	
	/**
	 * 新增角色模块
	 * @param fen
	 * @return
	 */
	Integer IntegerRolesModules(FenYe fen);
	/*
	 * 删除有关的角色模块
	 */
	Integer DeleteRolesModules(Integer id);
}

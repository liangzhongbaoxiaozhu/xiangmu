package com.lzb.dao;

import java.util.List;

import com.lzb.entity.FenYe;
import com.lzb.entity.Modules;
import com.lzb.entity.Roles;
import com.lzb.entity.Users;

public interface Rolesdao {

	/**
	 * 查询所有
	 * @param fen
	 * @return
	 */
	List<Roles> SelectRoles(FenYe fen);
	
	/**
	 * 查询总条数
	 * @param fen
	 * @return
	 */
	Integer SelectCount(FenYe fen);
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
	 * 查询角色所有的子模块id
	 * @return
	 */
	List<Modules> SelectRolesModulesid(Integer id);
	/**
	 * 查询所有父id
	 * @return
	 */
	List<Modules> SelectModulesFuid();
	/*根据父模块id查子模块id*/
	List<Modules> SelectZiModules2(Integer id);
	/**
	 * 根据id查询模块
	 * @return
	 */
	Modules SelectModule(Integer id);
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

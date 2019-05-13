package com.lzb.dao;

import java.util.List;

import com.lzb.entity.FenYe;
import com.lzb.entity.Modules;
import com.lzb.entity.Roles;

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
	
}

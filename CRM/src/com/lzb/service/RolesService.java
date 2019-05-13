package com.lzb.service;

import java.util.List;

import com.lzb.entity.FenYe;
import com.lzb.entity.Roles;

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
}

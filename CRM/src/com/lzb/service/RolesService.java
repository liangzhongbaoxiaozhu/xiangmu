package com.lzb.service;

import java.util.List;

import com.lzb.entity.FenYe;
import com.lzb.entity.Roles;

public interface RolesService {

	/**
	 * ��ѯ����
	 * @param fen
	 * @return
	 */
	FenYe SelectRoles(FenYe fen);
	/**
	 * ����
	 * @param roles
	 * @return
	 */
	Integer InsertRoles(Roles roles);
	/**
	 * �޸�
	 * @param roles
	 * @return
	 */
	Integer UpdateRoles(Roles roles);
	
	/**
	 * ɾ��
	 * @param id
	 * @return
	 */
	Integer deleteRoles(Integer id);
}

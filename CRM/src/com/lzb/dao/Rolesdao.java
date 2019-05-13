package com.lzb.dao;

import java.util.List;

import com.lzb.entity.FenYe;
import com.lzb.entity.Modules;
import com.lzb.entity.Roles;

public interface Rolesdao {

	/**
	 * ��ѯ����
	 * @param fen
	 * @return
	 */
	List<Roles> SelectRoles(FenYe fen);
	
	/**
	 * ��ѯ������
	 * @param fen
	 * @return
	 */
	Integer SelectCount(FenYe fen);
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

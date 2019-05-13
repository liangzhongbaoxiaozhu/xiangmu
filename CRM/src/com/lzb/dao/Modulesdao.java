package com.lzb.dao;

import java.util.List;

import com.lzb.entity.FenYe;
import com.lzb.entity.Modules;
import com.lzb.entity.Roles;

public interface Modulesdao {

	/*�����û�id���ɫ*/
	List<Roles> SelectRoles(Integer id);
	/*���ݽ�ɫ��ģ��id*/
	List<Modules> SelectModules(Integer id);
	/*���ݸ�ģ��id����ģ��id*/
	List<Modules> SelectZiModules(Integer id);
	
	
	/**
	 * ��ѯ����
	 * @param fen
	 * @return
	 */
	List<Roles> SelectModuless(FenYe fen);
	
	/**
	 * ��ѯ������
	 * @param fen
	 * @return
	 */
	Integer SelectCount(FenYe fen);
	/**
	 * ����
	 * @param Modules
	 * @return
	 */
	Integer InsertModules(Modules modules);
	/**
	 * �޸�
	 * @param Modules
	 * @return
	 */
	Integer UpdateModules(Modules modules);
	
	/**
	 * ɾ��
	 * @param id
	 * @return
	 */
	Integer deleteModules(Integer id);
	
	
}

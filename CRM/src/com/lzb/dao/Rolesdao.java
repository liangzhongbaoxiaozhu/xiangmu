package com.lzb.dao;

import java.util.List;

import com.lzb.entity.FenYe;
import com.lzb.entity.Modules;
import com.lzb.entity.Roles;
import com.lzb.entity.Users;

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
	
	/**
	 * �����û���ѯ��ɫ���е���ģ��id
	 * @return
	 */
	List<Modules> SelectRolesModulesid(Integer id);
	
	/**
	 * ���ݽ�ɫ���е���ģ��id
	 * @return
	 */
	List<Modules> SelectRolesZhuangYong(Integer id);
	
	/**
	 * ��ѯ���и�id
	 * @return
	 */
	List<Modules> SelectModulesFuid();
	
	/**
	 * ���ݸ�ģ��id����ģ��id
	 * @param id
	 * @return
	 */
	List<Modules> SelectZiModules2(Integer id);
	
	/**
	 * ����id��ѯģ��
	 * @return
	 */
	Modules SelectModule(Integer id);
	
	/**
	 * ������ɫģ��
	 * @param fen
	 * @return
	 */
	Integer IntegerRolesModules(FenYe fen);
	
	/**
	 * ɾ���йصĽ�ɫģ��
	 */
	Integer DeleteRolesModules(Integer id);
	
	/**
	 * ���ݽ�ɫid��ѯ�û���ɫ�Ƿ����
	 * @param id
	 * @return
	 */
	Integer selectUserRolesCount(Integer id);
	/**
	 * �������ֲ�ѯ�Ƿ����
	 * @param mingzi
	 * @return
	 */
	Roles selectMingZi(String mingzi);
	
}

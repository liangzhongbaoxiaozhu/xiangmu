package com.lzb.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.lzb.entity.FenYe;
import com.lzb.entity.Modules;
import com.lzb.entity.Roles;
import com.lzb.entity.TreeNode;

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
	
	/**
	 * ��ѯ���и�id
	 * @return
	 */
	TreeNode SelectModulesFuid(Integer id,Integer uid);
	/**
	 * ��ѯ���и�id
	 * @return
	 */
	List<Modules> SelectModulesFuid2();
	/*���ݸ�ģ��id����ģ��id*/
	/*List<Modules> SelectZiModules2(Integer id);*/
	
	/**
	 * ������ɫģ��
	 * @param fen
	 * @return
	 */
	Integer IntegerRolesModules(FenYe fen);
	/*
	 * ɾ���йصĽ�ɫģ��
	 */
	Integer DeleteRolesModules(Integer id);
}

package com.lzb.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.lzb.entity.FenYe;
import com.lzb.entity.Modules;
import com.lzb.entity.Roles;
import com.lzb.entity.TreeNode;

public interface ModulesService {

	/*�����û�id���ɫ*/
	TreeNode SelectCaiDan(Integer id,Integer uid);
	
	
	
	/**
	 * ��ѯ����
	 * @param fen
	 * @return
	 */
	FenYe SelectModuless(FenYe fen);
	
	/**
	 * ����
	 * @param roles
	 * @return
	 */
	Integer InsertModules(Modules modules);
	/**
	 * �޸�
	 * @param roles
	 * @return
	 */
	Integer UpdateModules(Modules modules);
	
	/**
	 * ɾ��
	 * @param id
	 * @return
	 */
	Integer deleteModules(Integer id);
	
	
	/**
	 * ��ѯ���и�id
	 * @return
	 */
	List<Modules> SelectFuidMoKuai();
	/*���ݸ�ģ��id����ģ��id*/
	TreeNode SelectFuChaZiMoKuai(Integer id);
	
	
}

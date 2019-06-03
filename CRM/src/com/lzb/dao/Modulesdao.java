package com.lzb.dao;

import java.util.List;

import com.lzb.entity.FenYe;
import com.lzb.entity.Modules;
import com.lzb.entity.Roles;

public interface Modulesdao {

	/**
	 * �����û�id���ɫ
	 * @param id
	 * @return
	 */
	List<Roles> SelectRoles(Integer id);
	
	/**
	 * ���ݽ�ɫ��ģ��id
	 * @param id
	 * @return
	 */
	List<Modules> SelectModules(Integer id);
	
	/**
	 * ���ݸ�ģ��id����ģ��id
	 * @param id
	 * @return
	 */
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
	
	//������
	
	/**
	 * ��ѯ���и�id
	 * @return
	 */
	List<Modules> SelectFuidMoKuai();
	
	/**
	 * ���ݸ�ģ��id����ģ��id
	 * @param id
	 * @return
	 */
	List<Modules> SelectFuChaZiMoKuai(Integer id);
	
	/**
	 * ����id��ѯ��ģ��
	 * @return
	 */
	Modules SelectChaZiMoKuai(Integer id);
	
	/**
	 * ����id��ѯģ��
	 * @param id
	 * @return
	 */
	Modules SelectMoKuai(Integer id);
	
	/**
	 * ����id��ѯģ���ɫ
	 * @param id
	 * @return
	 */
	List<Modules> SelectRMoKuai(Integer id);
	
	/**
	 * �������ֲ�ѯģ��
	 * @param mizi
	 * @return
	 */
	List<Modules> SelectMiZi(String mizi);
	
	/**
	 * ��Ӹ�ģ��
	 * @param modules
	 * @return
	 */
	Integer IntegerFuMoKuai(Modules modules);
	
}

package com.lzb.dao;

import java.util.List;

import com.lzb.entity.FenYe;
import com.lzb.entity.Modules;
import com.lzb.entity.Roles;
import com.lzb.entity.Users;

public interface Usersdao {

	/**
	 * ��¼
	 * @param user
	 * @return
	 */
	Users DengLu(Users user);
	
	/**
	 * ��ѯ����
	 * @param fen
	 * @return
	 */
	List<Users> SelectUsers(FenYe fen);
	
	/**
	 * ��ѯ���д���ʱ��
	 * @param fen
	 * @return
	 */
	List<Users> SelectUsersCuanJian(FenYe fen);
	
	/**
	 * ��ѯ��������¼ʱ��
	 * @param fen
	 * @return
	 */
	List<Users> SelectUserszuihou(FenYe fen);
	
	/**
	 * ��ѯ������
	 * @param fen
	 * @return
	 */
	Integer SelectCount(FenYe fen);
	
	/**
	 * ����
	 * @param Users
	 * @return
	 */
	Integer InsertUsers(Users users);
	
	/**
	 * �޸�
	 * @param users
	 * @return
	 */
	Integer updateUsers(Users users);
	
	/**
	 * ɾ��
	 * @param id
	 * @return
	 */
	Integer deleteUsers(Integer id);
	
	/**
	 * ����
	 * @param id
	 * @return
	 */
	Integer isShuoDing(Integer id);
	
	/**
	 * ����
	 * @param id
	 * @return
	 */
	Integer noShuoDing(Integer id);
	
	/**
	 * �����û����ɫ
	 * @return
	 */
	List<Roles> SelectRolesUsers(Integer id);
	
	/**
	 * ��ѯ���н�ɫ
	 * @return
	 */
	List<Roles> SelectRoles();
	
	/**
	 * ��ӽ�ɫ
	 * @param UserId
	 * @param RoleId
	 * @return
	 */
	Integer InsertUserRoles(FenYe fen);
	
	/**
	 * ɾ����ɫ
	 * @param URrid
	 * @return
	 */
	Integer deleteUserRoles(FenYe fen);
	
	/**
	 * ��ѯ�Ƿ�����ͬ�Ľ�ɫ�û�
	 * @param fen
	 * @return
	 */
	Integer SelectCountUsers(FenYe fen);
	
	/**
	 * ��ѯ�Ƿ�����ͬ���û���
	 * @param name
	 * @return
	 */
	Integer SelectName(String name);
	
	/**
	 * ��������
	 * @param id
	 * @return
	 */
	Integer updateMiMa(Users user);
	
	/**
	 * �鿴������Ϣ
	 * @param uid
	 * @return
	 */
	List<Users> SelectGeRen(Integer uid);
	
	/**
	 * ǩ��
	 * @param uid
	 * @return
	 */
	Integer QianDao(Users user);
	
	/**
	 * �޸ĸ�������
	 * @param fen
	 * @return
	 */
	Integer UpdateGeRenMiMa(Users user);
	
	/**
	 * ��ѯǩ��
	 * @param fen
	 * @return
	 */
	List<Users> SelectQianDao(FenYe fen);
	
	/**
	 * ��ѯǩ��������
	 * @param fen
	 * @return
	 */
	Integer SelectQianDaoCount(FenYe fen);
	
	/**
	 * ǩ��
	 * @param uid
	 * @return
	 */
	Integer SelectQianTui(Integer uid);
	
	/**
	 * ����Ȩ��
	 * @param user
	 * @return Integer
	 */
	Integer updateQuanZhong(Users user);
	
	/**
	 * ��ѯ�Զ�����
	 * @return
	 */
	String SelectZiDongFenPei();
	
	/**
	 * ����
	 * @param zidong
	 * @return
	 */
	Integer updateZiDongFenPei();
	
	/**
	 * �ر�
	 * @return
	 */
	Integer updateguanbiZiDong();
	/**
	 * ��ѯ����ǩ��״̬
	 * @param uid
	 * @return
	 */
	Users SelectGeRenQianDao(Integer uid);
	/**
	 * ����
	 * @param uid
	 * @return
	 */
	Integer updateChiDao(Integer uid);
	/**
	 * ��ѯ������ˣ������޸�
	 * @return
	 */
	List<Users> SelectKuanBan();
}

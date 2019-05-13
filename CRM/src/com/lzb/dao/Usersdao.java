package com.lzb.dao;

import java.util.List;

import com.lzb.entity.FenYe;
import com.lzb.entity.Modules;
import com.lzb.entity.Roles;
import com.lzb.entity.Users;

public interface Usersdao {

	/*��¼*/
	Users DengLu(Users user);
	
	
	
	/**
	 * ��ѯ����
	 * @param fen
	 * @return
	 */
	List<Users> SelectUsers(FenYe fen);
	
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
	Integer deleteUserRoles(Integer URrid);
}

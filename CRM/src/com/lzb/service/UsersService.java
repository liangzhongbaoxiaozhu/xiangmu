package com.lzb.service;

import java.util.List;

import com.lzb.entity.FenYe;
import com.lzb.entity.Roles;
import com.lzb.entity.Users;

public interface UsersService {

	/*��¼*/
	Users DengLu(Users user);
	
	
	/**
	 * ��ѯ����
	 * @param fen
	 * @return
	 */
	FenYe SelectUsers(FenYe fen);
	
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
	FenYe SelectRolesUsers(Integer id);
	/**
	 * ��ѯ���н�ɫ
	 * @return
	 */
	FenYe SelectRoles();
	/**
	 * ��ӽ�ɫ
	 * @param UserId
	 * @param RoleId
	 * @return
	 */
	Integer InsertUserRoles(Integer UserId,Integer RoleId);
	/**
	 * ɾ����ɫ
	 * @param URrid
	 * @return
	 */
	Integer deleteUserRoles(Integer URrid);
}

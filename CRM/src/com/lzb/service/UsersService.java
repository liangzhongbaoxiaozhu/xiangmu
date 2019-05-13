package com.lzb.service;

import java.util.List;

import com.lzb.entity.FenYe;
import com.lzb.entity.Roles;
import com.lzb.entity.Users;

public interface UsersService {

	/*登录*/
	Users DengLu(Users user);
	
	
	/**
	 * 查询所有
	 * @param fen
	 * @return
	 */
	FenYe SelectUsers(FenYe fen);
	
	/**
	 * 新增
	 * @param Users
	 * @return
	 */
	Integer InsertUsers(Users users);
	
	
	/**
	 * 删除
	 * @param id
	 * @return
	 */
	Integer deleteUsers(Integer id);
	/**
	 * 锁定
	 * @param id
	 * @return
	 */
	Integer isShuoDing(Integer id);
	/**
	 * 解锁
	 * @param id
	 * @return
	 */
	Integer noShuoDing(Integer id);
	/**
	 * 根据用户查角色
	 * @return
	 */
	FenYe SelectRolesUsers(Integer id);
	/**
	 * 查询所有角色
	 * @return
	 */
	FenYe SelectRoles();
	/**
	 * 添加角色
	 * @param UserId
	 * @param RoleId
	 * @return
	 */
	Integer InsertUserRoles(Integer UserId,Integer RoleId);
	/**
	 * 删除角色
	 * @param URrid
	 * @return
	 */
	Integer deleteUserRoles(Integer URrid);
}

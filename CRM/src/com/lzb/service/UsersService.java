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
	Integer deleteUserRoles(Integer UserId, Integer RoleId);
	/**
	 * 查询是否有相同的角色用户
	 * @param fen
	 * @return
	 */
	Integer SelectCountUsers(Integer UserId, Integer RoleId);
	/**
	 * 修改
	 * @param users
	 * @return
	 */
	Integer updateUsers(Users users);
	/**
	 * 重置密码
	 * @param id
	 * @return
	 */
	Integer updateMiMa(Integer id);
	
	
	/**
	 * 查看个人信息
	 * @param uid
	 * @return
	 */
	FenYe SelectGeRen(Integer uid);
	/**
	 * 签到
	 * @param uid
	 * @return
	 */
	Integer QianDao(Users user);

	/**
	 * 修改个人密码
	 * @param fen
	 * @return
	 */
	Integer UpdateGeRenMiMa(Users user);
	/**
	 * 查询签到
	 * @param fen
	 * @return
	 */
	FenYe SelectQianDao(FenYe fen);
	/**
	 * 签退
	 * @param uid
	 * @return
	 */
	Integer SelectQianTui(Integer uid);
	
}

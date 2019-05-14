package com.lzb.dao;

import java.util.List;

import com.lzb.entity.FenYe;
import com.lzb.entity.Modules;
import com.lzb.entity.Roles;
import com.lzb.entity.Users;

public interface Usersdao {

	/*登录*/
	Users DengLu(Users user);
	
	
	
	/**
	 * 查询所有
	 * @param fen
	 * @return
	 */
	List<Users> SelectUsers(FenYe fen);
	
	/**
	 * 查询所有创建时间
	 * @param fen
	 * @return
	 */
	List<Users> SelectUsersCuanJian(FenYe fen);
	
	/**
	 * 查询所有最后登录时间
	 * @param fen
	 * @return
	 */
	List<Users> SelectUserszuihou(FenYe fen);
	/**
	 * 查询总条数
	 * @param fen
	 * @return
	 */
	Integer SelectCount(FenYe fen);
	/**
	 * 新增
	 * @param Users
	 * @return
	 */
	Integer InsertUsers(Users users);
	/**
	 * 修改
	 * @param users
	 * @return
	 */
	Integer updateUsers(Users users);
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
	List<Roles> SelectRolesUsers(Integer id);
	/**
	 * 查询所有角色
	 * @return
	 */
	List<Roles> SelectRoles();
	/**
	 * 添加角色
	 * @param UserId
	 * @param RoleId
	 * @return
	 */
	Integer InsertUserRoles(FenYe fen);
	/**
	 * 删除角色
	 * @param URrid
	 * @return
	 */
	Integer deleteUserRoles(FenYe fen);
	/**
	 * 查询是否有相同的角色用户
	 * @param fen
	 * @return
	 */
	Integer SelectCountUsers(FenYe fen);
	/**
	 * 查询是否有相同的用户名
	 * @param name
	 * @return
	 */
	Integer SelectName(String name);
	/**
	 * 重置密码
	 * @param id
	 * @return
	 */
	Integer updateMiMa(Integer id);
}

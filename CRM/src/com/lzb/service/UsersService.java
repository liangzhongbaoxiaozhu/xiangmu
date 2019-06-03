package com.lzb.service;

import java.util.List;

import com.lzb.entity.FenYe;
import com.lzb.entity.Roles;
import com.lzb.entity.Users;

public interface UsersService {

	/*登录*/
	Users DengLu(Users user);
	
	//用户名验证
	Users YongHuMing(Users user);
	
	//是否锁定验证
	Users SuoDing(Users user);
	
	//查询所有
	FenYe SelectUsers(FenYe fen);
	
	//新增
	Integer InsertUsers(Users users);
	
	//删除
	Integer deleteUsers(Integer id);
	
	//锁定
	Integer isShuoDing(Integer id);
	
	//解锁
	Integer noShuoDing(Integer id);
	
	//根据用户查角色
	FenYe SelectRolesUsers(Integer id);
	
	//查询所有角色
	FenYe SelectRoles();
	
	//添加角色
	Integer InsertUserRoles(Integer UserId,Integer RoleId);
	
	//删除角色
	Integer deleteUserRoles(Integer UserId, Integer RoleId);
	
	//查询是否有相同的角色用户
	Integer SelectCountUsers(Integer UserId, Integer RoleId);
	
	//修改
	Integer updateUsers(Users users);
	
    //重置密码
	Integer updateMiMa(Integer id);
	
	//查看个人信息
	FenYe SelectGeRen(Integer uid);
	
	//签到
	Integer QianDao(Users user);

	//修改个人密码
	Integer UpdateGeRenMiMa(Users user);
	
	//查询签到
	FenYe SelectQianDao(FenYe fen);
	
	//签退
	Integer SelectQianTui(Integer uid,String data);
	
	//分配权重
	Integer updateQuanZhong(Users user);
	
	//开启
	Integer updateZiDongFenPei();
	
	//关闭
	Integer updateguanbiZiDong();
	
	//查询自动分配
	String SelectZiDongFenPei();
	
	//查询个人签到状态
	Users SelectGeRenQianDao(Integer uid);
	
	//旷班
	Integer updateChiDao();
	
	//早退
	Integer SelectZhaoTui(Integer uid);
	
	//判断签退10分钟
	String SelectQianTuiShi(Integer uid);
}

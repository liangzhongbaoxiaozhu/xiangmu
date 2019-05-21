package com.lzb.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lzb.entity.FenYe;
import com.lzb.entity.Modules;
import com.lzb.entity.Users;
import com.lzb.service.UsersService;

@Controller
public class UsersController {

	@Autowired
	private UsersService usersService;
	
	
	
	@RequestMapping(value="/SelectUsers",method=RequestMethod.POST)
	@ResponseBody
	public FenYe SelectUsers(Integer page,Integer rows,String loginName,Integer isLoginData,String cuanjiankaishi,String cuanjianjieshu,Integer paixu){
		FenYe fen=new FenYe();
		fen.setPage((page-1)*rows);
		fen.setPageSize(rows);
		fen.setLoginName(loginName);
		fen.setCuanjianjieshu(cuanjianjieshu);
		fen.setCuanjiankaishi(cuanjiankaishi);
		fen.setIsLoginData(isLoginData);
		fen.setPaixu(paixu);
		fen = usersService.SelectUsers(fen);
		return fen;
	}
	@RequestMapping(value="/InsertUsers",method=RequestMethod.POST)
	@ResponseBody
	public Integer InsertUsers(String loginName,String passWord,String email,Integer mtel){
		Date t = new Date();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		/*System.out.println(df.format(t));*/
		Users users=new Users();
		users.setCreateData(df.format(t));
		users.setLoginName(loginName);
		users.setPassWord(passWord);
		users.setEmail(email);
		users.setMtel(mtel);
		Integer insertRoles = usersService.InsertUsers(users);
		return insertRoles;
	}
	
	
	@RequestMapping(value="/DeleteUsers",method=RequestMethod.POST)
	@ResponseBody
	public Integer DeleteUsers(Integer id){
		Integer deleteRoles = usersService.deleteUsers(id);
		return deleteRoles;
	}
	
	@RequestMapping(value="/isShuoDing",method=RequestMethod.POST)
	@ResponseBody
	public Integer isShuoDing(Integer id){
		Integer updateRoles = usersService.isShuoDing(id);
		return updateRoles;
	}
	@RequestMapping(value="/noShuoDing",method=RequestMethod.POST)
	@ResponseBody
	public Integer noShuoDing(Integer id){
		Integer updateRoles = usersService.noShuoDing(id);
		return updateRoles;
	}
	//根据用户id查询角色
	@RequestMapping(value="/SelectRolesUsers",method=RequestMethod.POST)
	@ResponseBody
	public FenYe SelectRolesUsers(Integer id){
		FenYe selectRolesUsers = usersService.SelectRolesUsers(id);
		return selectRolesUsers;
	}
	//查询所有角色
	@RequestMapping(value="/SelectURoles",method=RequestMethod.POST)
	@ResponseBody
	public FenYe SelectURoles(){
		FenYe selectRoles = usersService.SelectRoles();
		return selectRoles;
	}
	//增加用户角色
	@RequestMapping(value="/InsertUserRoles",method=RequestMethod.POST)
	@ResponseBody
	public Integer InsertUserRoles(Integer userId, Integer roleId){
		Integer selectCountUsers = usersService.SelectCountUsers(userId, roleId);
		if(selectCountUsers==null||selectCountUsers==0){
			Integer insertUserRoles = usersService.InsertUserRoles(userId, roleId);
			return insertUserRoles;
		}else{
			return 0;
		}
		
	}

	//删除用户角色
	@RequestMapping(value="/deleteUserRoles",method=RequestMethod.POST)
	@ResponseBody
	public Integer deleteUserRoles(Integer userId, Integer roleId){
		Integer selectCountUsers = usersService.SelectCountUsers(userId, roleId);
		if(selectCountUsers>0){
			Integer deleteUserRoles = usersService.deleteUserRoles(userId,roleId);
			return deleteUserRoles;
		}else{
			return 0;
		}
	}
	
	
	//修改
		@RequestMapping(value="/updateUser",method=RequestMethod.POST)
		@ResponseBody
		public Integer updateUser(Users users){
			Integer updateUsers = usersService.updateUsers(users);
				return updateUsers;
			}
		
		//修改密码
		@RequestMapping(value="/updateMiMa",method=RequestMethod.POST)
	    @ResponseBody
		public Integer updateMiMa(Integer id){
		    Integer updateMiMa = usersService.updateMiMa(id);
			return updateMiMa;
		}
	//查询个人
		@RequestMapping(value="/SelectGe",method=RequestMethod.POST)
	    @ResponseBody
		public FenYe SelectGe(Integer uid){
			FenYe fen=usersService.SelectGeRen(uid);
			return fen;
		}
		
		//签到
		@RequestMapping(value="/Qian",method=RequestMethod.POST)
		@ResponseBody
		public Integer Qian(Integer uid){
			Users user =new Users();
			user.setUid(uid);
			Date t = new Date();
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			user.setSignInData(df.format(t));
			Integer SelectGeRen = usersService.QianDao(user);
			return SelectGeRen;
		}
		//修改密码
		@RequestMapping(value="/UpdateGeReMiMa",method=RequestMethod.POST)
		@ResponseBody
		public Integer UpdateGeReMiMa(Integer uid,String passWord,String mima){
			Users user =new Users();
			user.setUid(uid);
			user.setPassWord(passWord);
			user.setMiMa(mima);
			Integer UpdateGeRenMiMa = usersService.UpdateGeRenMiMa(user);
			return UpdateGeRenMiMa;
		}
		//查询签到页面
		@RequestMapping(value="/SelectQianDao",method=RequestMethod.POST)
		@ResponseBody
		public FenYe SelectQianDao(Integer page,Integer rows,String loginName,Integer signIn,String cuanjiankaishi,String cuanjianjieshu){
			FenYe fen=new FenYe();
			fen.setCuanjianjieshu(cuanjianjieshu);
			fen.setCuanjiankaishi(cuanjiankaishi);
			fen.setPage((page-1)*rows);
			fen.setPageSize(rows);
			fen.setLoginName(loginName);
			fen.setSignIn(signIn);
			FenYe selectQianDao = usersService.SelectQianDao(fen);
			return selectQianDao;
		}	
		//签退
		@RequestMapping(value="/UpdateQianTui",method=RequestMethod.POST)
		@ResponseBody
		public Integer UpdateQianTui(String uid){
			String[] split = uid.split(",");
			for(int i=0;i<split.length;i++){
				Integer selectQianTui = usersService.SelectQianTui(Integer.parseInt(split[i]));
				if(selectQianTui<1){
					return selectQianTui;
				}
			}
			return 1;
		}		
	    //修改权重
		@RequestMapping(value="/UpdateQuanZhong",method=RequestMethod.POST)
		@ResponseBody
		public Integer UpdateQuanZhong(Integer uid,Integer weight,String remarks){
			Users user=new Users();
			user.setUid(uid);
			user.setWeight(weight);
			user.setRemarks(remarks);
			
			Integer updateQuanZhong = usersService.updateQuanZhong(user);
			return updateQuanZhong;
		}
		//查询自动分配
		@RequestMapping(value="/selectzidongfen",method=RequestMethod.POST)
		@ResponseBody
		public String selectzidongfen(){
			String selectZiDongFenPei = usersService.SelectZiDongFenPei();
			return selectZiDongFenPei;
		}
		//开启自动分配
		@RequestMapping(value="/kaiqizidong",method=RequestMethod.POST)
		@ResponseBody
		public Integer kaiqizidong(){
			Integer updateZiDongFenPei = usersService.updateZiDongFenPei();
			return updateZiDongFenPei;
		}
		//关闭自动分配
		@RequestMapping(value="/guanbizidong",method=RequestMethod.POST)
		@ResponseBody
		public Integer guanbizidong(){
			Integer updateguanbiZiDong = usersService.updateguanbiZiDong();
			return updateguanbiZiDong;
		}		
}

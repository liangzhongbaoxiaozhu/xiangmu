package com.lzb.controller;

import java.text.DateFormat;
import java.text.ParseException;
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
import com.lzb.entity.Statistics;
import com.lzb.entity.Users;
import com.lzb.service.StatisticsService;
import com.lzb.service.UsersService;

@Controller
public class UsersController {

	@Autowired
	private UsersService usersService;
	@Autowired
	private StatisticsService statisticsService;
	
	
	
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
	public Integer InsertUsers(String loginName,String passWord,String email,String mtel){
		Date t = new Date();
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		/*System.out.println(df.format(t));*/
		Users users=new Users();
		users.setCreateData(df.format(t));
		users.setLoginName(loginName);
		users.setPassWord(passWord);
		users.setEmail(email);
		users.setMtel(mtel);
		users.setSignInData(df.format(t));
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
		@RequestMapping(value="/Qian",method=RequestMethod.POST,produces = "text/plain;charset=utf-8")
		@ResponseBody
		public String Qian(Integer uid) throws ParseException{
			
			String zhuangtai="";
			Users user =new Users();
			user.setUid(uid);
			Date t = new Date();
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			SimpleDateFormat XianShiShiJian = new SimpleDateFormat("HH:mm:ss");
			
			//用户登录时间
			String YongHuDengLuShiJian=XianShiShiJian.format(t);
			Date  uhdlsj=XianShiShiJian.parse(YongHuDengLuShiJian);
			//登录限定时间
			Date dqsj=XianShiShiJian.parse("09:00:00");
			
			//迟到限定时间时间
			Date cdsj=XianShiShiJian.parse("10:00:00");
			
			// 签退 0  签到  1 迟到  2 早退 3 旷班 4
			
			System.out.println("用户登录时间:"+uhdlsj);
			/*System.out.println("登录限定时间:"+dqsj);*/
			System.out.println("用户登录判定:"+uhdlsj.before(dqsj));
			System.out.println("用户迟到判定:"+uhdlsj.before(cdsj));
			
			if(uhdlsj.before(dqsj)){
				Statistics sta = statisticsService.SelectById(uid);
				sta.setQiandao((sta.getQiandao()+1));
				statisticsService.UpdateQianDao(sta);
				user.setSignIn(1);
				zhuangtai="签到成功！";
				user.setSignInData(df.format(t));
				Integer SelectGeRen = usersService.QianDao(user);
			}
			if(uhdlsj.before(cdsj)){
				Statistics sta = statisticsService.SelectById(uid);
				sta.setChidao((sta.getChidao()+1));
				statisticsService.UpdateChiDao(sta);
				user.setSignIn(2);
				zhuangtai="签到成功！您已迟到！";
				user.setSignInData(df.format(t));
				Integer SelectGeRen = usersService.QianDao(user);
			}
			if(cdsj.before(uhdlsj)){
				zhuangtai="已超过签到时间！";
			}
			
			
			return zhuangtai;
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
		@RequestMapping(value="/UpdateQianTui",method=RequestMethod.POST,produces = "text/plain;charset=utf-8")
		@ResponseBody
		public String UpdateQianTui(String uid) throws ParseException{
			
			Date t = new Date();
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			SimpleDateFormat XianShiShiJian = new SimpleDateFormat("HH:mm:ss");
			
			//用户签退时间
			String YongHuDengLuShiJian=XianShiShiJian.format(t);
			Date  uhdtsj=XianShiShiJian.parse(YongHuDengLuShiJian);
			//签退限定时间
			Date dtsj=XianShiShiJian.parse("17:00:00");
			
			System.out.println("用户签退时间:"+uhdtsj);
			System.out.println("用户签退判定:"+dtsj.before(uhdtsj));
			
			String huihua="签退时间未到，请到时间下班！";
			
			if(dtsj.before(uhdtsj)){
				
				huihua="签退成功！";
			String[] split = uid.split(",");
			for(int i=0;i<split.length;i++){
				
				Integer selectQianTui = usersService.SelectQianTui(Integer.parseInt(split[i]),df.format(t));
				
				if(selectQianTui<1){
					huihua="签退失败，请找管理员!";
				}
			}
			}
			return huihua;
		}
		//早退
		@RequestMapping(value="/UpdateZaoTui",method=RequestMethod.POST,produces = "text/plain;charset=utf-8")
		@ResponseBody
		public String UpdateZaoTui(String uid) throws ParseException{
					
					Date t = new Date();
					SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					SimpleDateFormat XianShiShiJian = new SimpleDateFormat("HH:mm:ss");
					
					//用户签退时间
					/*String YongHuDengLuShiJian=XianShiShiJian.format(t);
					Date  uhdtsj=XianShiShiJian.parse(YongHuDengLuShiJian);
					//签退限定时间
					Date zaotuis=XianShiShiJian.parse("08:00:00");
					Date zaotuix=XianShiShiJian.parse("17:00:00");
					
					System.out.println("用户签退时间:"+uhdtsj);
					System.out.println("用户早退上判定:"+zaotuis.before(uhdtsj));
					System.out.println("用户早退下判定:"+uhdtsj.before(zaotuix));
					String huihua="签退失败！";*/
					
					/*if(zaotuis.before(uhdtsj)&&uhdtsj.before(zaotuix)){
						huihua="签退成功！";*/
					String huihua="签退失败！";
					String[] split = uid.split(",");
					for(int i=0;i<split.length;i++){
						if(split[i]!=""){
							
							String selectQianTuiShi = usersService.SelectQianTuiShi(Integer.parseInt(split[i]));
							if(Integer.parseInt(selectQianTuiShi)>10){
								//记录
								Statistics sta = statisticsService.SelectById(Integer.parseInt(split[i]));
								sta.setQingjia((sta.getQingjia()+1));
								statisticsService.UpdateQingJia(sta);
								
								Integer selectQianTui = usersService.SelectZhaoTui(Integer.parseInt(split[i]));
								huihua="签退成功！";
								if(selectQianTui<1){
									huihua="签退失败，请找管理员!";
								}
							}else{
								huihua="签退失败，签到未满十分钟!";
							}
							
						}
						
					/*}*/
					}
					return huihua;
				}
		//旷班
		@RequestMapping(value="/KuangBan",method=RequestMethod.POST)
		@ResponseBody
			public Integer KuangBan(){
			Integer updateChiDao = usersService.updateChiDao();
				return updateChiDao;
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
		//查询个人签到状态
		@RequestMapping(value="/SelectGeRenQianDaoZhuangTai",method=RequestMethod.POST)
		@ResponseBody
		public Integer SelectGeRenQianDaoZhuangTai(Integer uid){
			Users selectGeRenQianDao = usersService.SelectGeRenQianDao(uid);
			return selectGeRenQianDao.getSignIn();
		}		
}

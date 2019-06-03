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
	//�����û�id��ѯ��ɫ
	@RequestMapping(value="/SelectRolesUsers",method=RequestMethod.POST)
	@ResponseBody
	public FenYe SelectRolesUsers(Integer id){
		FenYe selectRolesUsers = usersService.SelectRolesUsers(id);
		return selectRolesUsers;
	}
	//��ѯ���н�ɫ
	@RequestMapping(value="/SelectURoles",method=RequestMethod.POST)
	@ResponseBody
	public FenYe SelectURoles(){
		FenYe selectRoles = usersService.SelectRoles();
		return selectRoles;
	}
	//�����û���ɫ
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

	//ɾ���û���ɫ
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
	
	
	//�޸�
		@RequestMapping(value="/updateUser",method=RequestMethod.POST)
		@ResponseBody
		public Integer updateUser(Users users){
			Integer updateUsers = usersService.updateUsers(users);
				return updateUsers;
			}
		
		//�޸�����
		@RequestMapping(value="/updateMiMa",method=RequestMethod.POST)
	    @ResponseBody
		public Integer updateMiMa(Integer id){
		    Integer updateMiMa = usersService.updateMiMa(id);
			return updateMiMa;
		}
	//��ѯ����
		@RequestMapping(value="/SelectGe",method=RequestMethod.POST)
	    @ResponseBody
		public FenYe SelectGe(Integer uid){
			FenYe fen=usersService.SelectGeRen(uid);
			return fen;
		}
		
		//ǩ��
		@RequestMapping(value="/Qian",method=RequestMethod.POST,produces = "text/plain;charset=utf-8")
		@ResponseBody
		public String Qian(Integer uid) throws ParseException{
			
			String zhuangtai="";
			Users user =new Users();
			user.setUid(uid);
			Date t = new Date();
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			SimpleDateFormat XianShiShiJian = new SimpleDateFormat("HH:mm:ss");
			
			//�û���¼ʱ��
			String YongHuDengLuShiJian=XianShiShiJian.format(t);
			Date  uhdlsj=XianShiShiJian.parse(YongHuDengLuShiJian);
			//��¼�޶�ʱ��
			Date dqsj=XianShiShiJian.parse("09:00:00");
			
			//�ٵ��޶�ʱ��ʱ��
			Date cdsj=XianShiShiJian.parse("10:00:00");
			
			// ǩ�� 0  ǩ��  1 �ٵ�  2 ���� 3 ���� 4
			
			System.out.println("�û���¼ʱ��:"+uhdlsj);
			/*System.out.println("��¼�޶�ʱ��:"+dqsj);*/
			System.out.println("�û���¼�ж�:"+uhdlsj.before(dqsj));
			System.out.println("�û��ٵ��ж�:"+uhdlsj.before(cdsj));
			
			if(uhdlsj.before(dqsj)){
				Statistics sta = statisticsService.SelectById(uid);
				sta.setQiandao((sta.getQiandao()+1));
				statisticsService.UpdateQianDao(sta);
				user.setSignIn(1);
				zhuangtai="ǩ���ɹ���";
				user.setSignInData(df.format(t));
				Integer SelectGeRen = usersService.QianDao(user);
			}
			if(uhdlsj.before(cdsj)){
				Statistics sta = statisticsService.SelectById(uid);
				sta.setChidao((sta.getChidao()+1));
				statisticsService.UpdateChiDao(sta);
				user.setSignIn(2);
				zhuangtai="ǩ���ɹ������ѳٵ���";
				user.setSignInData(df.format(t));
				Integer SelectGeRen = usersService.QianDao(user);
			}
			if(cdsj.before(uhdlsj)){
				zhuangtai="�ѳ���ǩ��ʱ�䣡";
			}
			
			
			return zhuangtai;
		}
		//�޸�����
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
		//��ѯǩ��ҳ��
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
		//ǩ��
		@RequestMapping(value="/UpdateQianTui",method=RequestMethod.POST,produces = "text/plain;charset=utf-8")
		@ResponseBody
		public String UpdateQianTui(String uid) throws ParseException{
			
			Date t = new Date();
			SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			SimpleDateFormat XianShiShiJian = new SimpleDateFormat("HH:mm:ss");
			
			//�û�ǩ��ʱ��
			String YongHuDengLuShiJian=XianShiShiJian.format(t);
			Date  uhdtsj=XianShiShiJian.parse(YongHuDengLuShiJian);
			//ǩ���޶�ʱ��
			Date dtsj=XianShiShiJian.parse("17:00:00");
			
			System.out.println("�û�ǩ��ʱ��:"+uhdtsj);
			System.out.println("�û�ǩ���ж�:"+dtsj.before(uhdtsj));
			
			String huihua="ǩ��ʱ��δ�����뵽ʱ���°࣡";
			
			if(dtsj.before(uhdtsj)){
				
				huihua="ǩ�˳ɹ���";
			String[] split = uid.split(",");
			for(int i=0;i<split.length;i++){
				
				Integer selectQianTui = usersService.SelectQianTui(Integer.parseInt(split[i]),df.format(t));
				
				if(selectQianTui<1){
					huihua="ǩ��ʧ�ܣ����ҹ���Ա!";
				}
			}
			}
			return huihua;
		}
		//����
		@RequestMapping(value="/UpdateZaoTui",method=RequestMethod.POST,produces = "text/plain;charset=utf-8")
		@ResponseBody
		public String UpdateZaoTui(String uid) throws ParseException{
					
					Date t = new Date();
					SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
					SimpleDateFormat XianShiShiJian = new SimpleDateFormat("HH:mm:ss");
					
					//�û�ǩ��ʱ��
					/*String YongHuDengLuShiJian=XianShiShiJian.format(t);
					Date  uhdtsj=XianShiShiJian.parse(YongHuDengLuShiJian);
					//ǩ���޶�ʱ��
					Date zaotuis=XianShiShiJian.parse("08:00:00");
					Date zaotuix=XianShiShiJian.parse("17:00:00");
					
					System.out.println("�û�ǩ��ʱ��:"+uhdtsj);
					System.out.println("�û��������ж�:"+zaotuis.before(uhdtsj));
					System.out.println("�û��������ж�:"+uhdtsj.before(zaotuix));
					String huihua="ǩ��ʧ�ܣ�";*/
					
					/*if(zaotuis.before(uhdtsj)&&uhdtsj.before(zaotuix)){
						huihua="ǩ�˳ɹ���";*/
					String huihua="ǩ��ʧ�ܣ�";
					String[] split = uid.split(",");
					for(int i=0;i<split.length;i++){
						if(split[i]!=""){
							
							String selectQianTuiShi = usersService.SelectQianTuiShi(Integer.parseInt(split[i]));
							if(Integer.parseInt(selectQianTuiShi)>10){
								//��¼
								Statistics sta = statisticsService.SelectById(Integer.parseInt(split[i]));
								sta.setQingjia((sta.getQingjia()+1));
								statisticsService.UpdateQingJia(sta);
								
								Integer selectQianTui = usersService.SelectZhaoTui(Integer.parseInt(split[i]));
								huihua="ǩ�˳ɹ���";
								if(selectQianTui<1){
									huihua="ǩ��ʧ�ܣ����ҹ���Ա!";
								}
							}else{
								huihua="ǩ��ʧ�ܣ�ǩ��δ��ʮ����!";
							}
							
						}
						
					/*}*/
					}
					return huihua;
				}
		//����
		@RequestMapping(value="/KuangBan",method=RequestMethod.POST)
		@ResponseBody
			public Integer KuangBan(){
			Integer updateChiDao = usersService.updateChiDao();
				return updateChiDao;
		}
	    //�޸�Ȩ��
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
		//��ѯ�Զ�����
		@RequestMapping(value="/selectzidongfen",method=RequestMethod.POST)
		@ResponseBody
		public String selectzidongfen(){
			String selectZiDongFenPei = usersService.SelectZiDongFenPei();
			return selectZiDongFenPei;
		}
		//�����Զ�����
		@RequestMapping(value="/kaiqizidong",method=RequestMethod.POST)
		@ResponseBody
		public Integer kaiqizidong(){
			Integer updateZiDongFenPei = usersService.updateZiDongFenPei();
			return updateZiDongFenPei;
		}
		//�ر��Զ�����
		@RequestMapping(value="/guanbizidong",method=RequestMethod.POST)
		@ResponseBody
		public Integer guanbizidong(){
			Integer updateguanbiZiDong = usersService.updateguanbiZiDong();
			return updateguanbiZiDong;
		}
		//��ѯ����ǩ��״̬
		@RequestMapping(value="/SelectGeRenQianDaoZhuangTai",method=RequestMethod.POST)
		@ResponseBody
		public Integer SelectGeRenQianDaoZhuangTai(Integer uid){
			Users selectGeRenQianDao = usersService.SelectGeRenQianDao(uid);
			return selectGeRenQianDao.getSignIn();
		}		
}

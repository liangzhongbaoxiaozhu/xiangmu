package com.lzb.service;

import java.util.List;

import com.lzb.entity.FenYe;
import com.lzb.entity.Roles;
import com.lzb.entity.Users;

public interface UsersService {

	/*��¼*/
	Users DengLu(Users user);
	
	//�û�����֤
	Users YongHuMing(Users user);
	
	//�Ƿ�������֤
	Users SuoDing(Users user);
	
	//��ѯ����
	FenYe SelectUsers(FenYe fen);
	
	//����
	Integer InsertUsers(Users users);
	
	//ɾ��
	Integer deleteUsers(Integer id);
	
	//����
	Integer isShuoDing(Integer id);
	
	//����
	Integer noShuoDing(Integer id);
	
	//�����û����ɫ
	FenYe SelectRolesUsers(Integer id);
	
	//��ѯ���н�ɫ
	FenYe SelectRoles();
	
	//��ӽ�ɫ
	Integer InsertUserRoles(Integer UserId,Integer RoleId);
	
	//ɾ����ɫ
	Integer deleteUserRoles(Integer UserId, Integer RoleId);
	
	//��ѯ�Ƿ�����ͬ�Ľ�ɫ�û�
	Integer SelectCountUsers(Integer UserId, Integer RoleId);
	
	//�޸�
	Integer updateUsers(Users users);
	
    //��������
	Integer updateMiMa(Integer id);
	
	//�鿴������Ϣ
	FenYe SelectGeRen(Integer uid);
	
	//ǩ��
	Integer QianDao(Users user);

	//�޸ĸ�������
	Integer UpdateGeRenMiMa(Users user);
	
	//��ѯǩ��
	FenYe SelectQianDao(FenYe fen);
	
	//ǩ��
	Integer SelectQianTui(Integer uid);
	
	//����Ȩ��
	Integer updateQuanZhong(Users user);
	
	//����
	Integer updateZiDongFenPei();
	
	//�ر�
	Integer updateguanbiZiDong();
	
	//��ѯ�Զ�����
	String SelectZiDongFenPei();
	
	//��ѯ����ǩ��״̬
	Users SelectGeRenQianDao(Integer uid);
	
	//����
	Integer updateChiDao();
	
	//����
	Integer SelectZhaoTui(Integer uid);
}

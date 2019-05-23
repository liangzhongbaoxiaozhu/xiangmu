package com.lzb.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.lzb.entity.FenYe;
import com.lzb.entity.Modules;
import com.lzb.entity.Roles;
import com.lzb.entity.TreeNode;

public interface RolesService {

	//��ѯ����
	FenYe SelectRoles(FenYe fen);
	
	//����
	Integer InsertRoles(Roles roles);
	
	//�޸�
	Integer UpdateRoles(Roles roles);
	
	//ɾ��
	String deleteRoles(Integer id);
	
	//��ѯ���и�id
	TreeNode SelectModulesFuid(Integer id,Integer uid);
	
	//��ѯ���и�id
	List<Modules> SelectModulesFuid2();
	
    //������ɫģ��
	Integer IntegerRolesModules(FenYe fen);
	
	//ɾ���йصĽ�ɫģ��
	Integer DeleteRolesModules(Integer id);
}

package com.lzb.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.lzb.entity.FenYe;
import com.lzb.entity.Modules;
import com.lzb.entity.Roles;
import com.lzb.entity.TreeNode;

public interface ModulesService {

	//�����û�id���ɫ
	TreeNode SelectCaiDan(Integer id,Integer uid);
	
	//��ѯ����
	FenYe SelectModuless(FenYe fen);
	
    //����
	Integer InsertModules(Modules modules);
	
	//�޸�
	Integer UpdateModules(Modules modules);
	
	//ɾ��
	Integer deleteModules(Integer id);
	
	//��ѯ���и�id
	List<Modules> SelectFuidMoKuai();
	
	//���ݸ�ģ��id����ģ��id
	TreeNode SelectFuChaZiMoKuai(Integer id);
	
	
}

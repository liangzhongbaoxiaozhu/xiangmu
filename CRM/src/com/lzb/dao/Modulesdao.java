package com.lzb.dao;

import java.util.List;

import com.lzb.entity.Modules;
import com.lzb.entity.Roles;

public interface Modulesdao {

	/*�����û�id���ɫ*/
	List<Roles> SelectRoles(Integer id);
	/*���ݽ�ɫ��ģ��id*/
	List<Modules> SelectModules(Integer id);
	/*���ݸ�ģ��id����ģ��id*/
	List<Modules> SelectZiModules(Integer id);
	
}

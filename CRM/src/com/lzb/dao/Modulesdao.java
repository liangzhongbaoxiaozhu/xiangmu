package com.lzb.dao;

import java.util.List;

import com.lzb.entity.Modules;
import com.lzb.entity.Roles;

public interface Modulesdao {

	/*根据用户id查角色*/
	List<Roles> SelectRoles(Integer id);
	/*根据角色查模块id*/
	List<Modules> SelectModules(Integer id);
	/*根据父模块id查子模块id*/
	List<Modules> SelectZiModules(Integer id);
	
}

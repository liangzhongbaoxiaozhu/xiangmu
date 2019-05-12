package com.lzb.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.lzb.entity.Modules;
import com.lzb.entity.Roles;

public interface ModulesService {

	/*根据用户id查角色*/
	String SelectRoles(Integer id,HttpServletRequest request);
}

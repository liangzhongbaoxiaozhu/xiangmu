package com.lzb.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.lzb.entity.Modules;
import com.lzb.entity.Roles;

public interface ModulesService {

	/*�����û�id���ɫ*/
	String SelectRoles(Integer id,HttpServletRequest request);
}

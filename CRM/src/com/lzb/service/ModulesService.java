package com.lzb.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.lzb.entity.FenYe;
import com.lzb.entity.Modules;
import com.lzb.entity.Roles;
import com.lzb.entity.TreeNode;

public interface ModulesService {

	//根据用户id查角色
	TreeNode SelectCaiDan(Integer id,Integer uid);
	
	//查询所有
	FenYe SelectModuless(FenYe fen);
	
    //新增
	Integer InsertModules(Modules modules);
	
	//修改
	Integer UpdateModules(Modules modules);
	
	//删除
	Integer deleteModules(Integer id);
	
	//查询所有父id
	List<Modules> SelectFuidMoKuai();
	
	//根据父模块id查子模块id
	TreeNode SelectFuChaZiMoKuai(Integer id);
	
	//添加父模块
	Integer IntegerFuLei(Modules modules);
	
}

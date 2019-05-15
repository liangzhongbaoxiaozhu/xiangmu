package com.lzb.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.lzb.entity.FenYe;
import com.lzb.entity.Modules;
import com.lzb.entity.Roles;
import com.lzb.entity.TreeNode;

public interface ModulesService {

	/*根据用户id查角色*/
	TreeNode SelectCaiDan(Integer id,Integer uid);
	
	
	
	/**
	 * 查询所有
	 * @param fen
	 * @return
	 */
	FenYe SelectModuless(FenYe fen);
	
	/**
	 * 新增
	 * @param roles
	 * @return
	 */
	Integer InsertModules(Modules modules);
	/**
	 * 修改
	 * @param roles
	 * @return
	 */
	Integer UpdateModules(Modules modules);
	
	/**
	 * 删除
	 * @param id
	 * @return
	 */
	Integer deleteModules(Integer id);
	
	
	/**
	 * 查询所有父id
	 * @return
	 */
	List<Modules> SelectFuidMoKuai();
	/*根据父模块id查子模块id*/
	TreeNode SelectFuChaZiMoKuai(Integer id);
	
	
}

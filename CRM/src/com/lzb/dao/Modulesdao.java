package com.lzb.dao;

import java.util.List;

import com.lzb.entity.FenYe;
import com.lzb.entity.Modules;
import com.lzb.entity.Roles;

public interface Modulesdao {

	/**
	 * 根据用户id查角色
	 * @param id
	 * @return
	 */
	List<Roles> SelectRoles(Integer id);
	
	/**
	 * 根据角色查模块id
	 * @param id
	 * @return
	 */
	List<Modules> SelectModules(Integer id);
	
	/**
	 * 根据父模块id查子模块id
	 * @param id
	 * @return
	 */
	List<Modules> SelectZiModules(Integer id);
	
	/**
	 * 查询所有
	 * @param fen
	 * @return
	 */
	List<Roles> SelectModuless(FenYe fen);
	
	/**
	 * 查询总条数
	 * @param fen
	 * @return
	 */
	Integer SelectCount(FenYe fen);
	
	/**
	 * 新增
	 * @param Modules
	 * @return
	 */
	Integer InsertModules(Modules modules);
	
	/**
	 * 修改
	 * @param Modules
	 * @return
	 */
	Integer UpdateModules(Modules modules);
	
	/**
	 * 删除
	 * @param id
	 * @return
	 */
	Integer deleteModules(Integer id);
	
	//新做的
	
	/**
	 * 查询所有父id
	 * @return
	 */
	List<Modules> SelectFuidMoKuai();
	
	/**
	 * 根据父模块id查子模块id
	 * @param id
	 * @return
	 */
	List<Modules> SelectFuChaZiMoKuai(Integer id);
	
	/**
	 * 根据id查询子模块
	 * @return
	 */
	Modules SelectChaZiMoKuai(Integer id);
	
	/**
	 * 根据id查询模块
	 * @param id
	 * @return
	 */
	Modules SelectMoKuai(Integer id);
	
	/**
	 * 根据id查询模块角色
	 * @param id
	 * @return
	 */
	List<Modules> SelectRMoKuai(Integer id);
	
	/**
	 * 根据名字查询模块
	 * @param mizi
	 * @return
	 */
	List<Modules> SelectMiZi(String mizi);
	
	/**
	 * 添加父模块
	 * @param modules
	 * @return
	 */
	Integer IntegerFuMoKuai(Modules modules);
	
}

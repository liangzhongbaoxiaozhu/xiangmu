package com.lzb.dao;

import java.util.List;

import com.lzb.entity.Statistics;
import com.lzb.entity.Users;

public interface Statisticsdao {

	/**
	 * 添加新员工
	 * @param users
	 * @return
	 */
	Integer InsertXinYuanGong(Statistics sta);
	
	/**
	 * 签到计数
	 * @param sta
	 * @return
	 */
	Integer UpdateQianDao(Statistics sta);
	
	/**
	 * 迟到
	 * @param sta
	 * @return
	 */
	Integer UpdateChiDao(Statistics sta);
	
	/**
	 * 请假
	 * @param sta
	 * @return
	 */
	Integer UpdateQingJia(Statistics sta);
	
	/**
	 * 根据id查询
	 * @param uid
	 * @return
	 */
	Statistics SelectById(Integer uid);
	
	/**
	 * 根据id删除
	 * @param uid
	 * @return
	 */
	Integer DeleteById(Integer uid);
	
	/**
	 * 查询所有
	 * @return
	 */
	List<Statistics> SelectStatistics();
	
	
}

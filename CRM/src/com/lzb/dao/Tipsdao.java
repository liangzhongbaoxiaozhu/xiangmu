package com.lzb.dao;

import java.util.List;

import com.lzb.entity.Tips;

public interface Tipsdao {
	
	/**
	 * 添加提醒消息
	 * @param tips
	 * @return
	 */
	Integer IntegerTips(Tips tips);
	
	/**
	 * 根据id查询消息
	 * @param tid
	 * @return
	 */
	List<Tips> selectTips(Integer tid);
	
	/**
	 * 根据id删除
	 * @param tid
	 * @return
	 */
	Integer deleteTips(Integer tid);
}

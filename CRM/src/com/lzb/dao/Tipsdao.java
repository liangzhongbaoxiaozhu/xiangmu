package com.lzb.dao;

import java.util.List;

import com.lzb.entity.Tips;

public interface Tipsdao {
	
	/**
	 * ���������Ϣ
	 * @param tips
	 * @return
	 */
	Integer IntegerTips(Tips tips);
	
	/**
	 * ����id��ѯ��Ϣ
	 * @param tid
	 * @return
	 */
	List<Tips> selectTips(Integer tid);
	
	/**
	 * ����idɾ��
	 * @param tid
	 * @return
	 */
	Integer deleteTips(Integer tid);
}

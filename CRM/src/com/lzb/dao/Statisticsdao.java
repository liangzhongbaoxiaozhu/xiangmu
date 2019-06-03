package com.lzb.dao;

import java.util.List;

import com.lzb.entity.Statistics;
import com.lzb.entity.Users;

public interface Statisticsdao {

	/**
	 * �����Ա��
	 * @param users
	 * @return
	 */
	Integer InsertXinYuanGong(Statistics sta);
	
	/**
	 * ǩ������
	 * @param sta
	 * @return
	 */
	Integer UpdateQianDao(Statistics sta);
	
	/**
	 * �ٵ�
	 * @param sta
	 * @return
	 */
	Integer UpdateChiDao(Statistics sta);
	
	/**
	 * ���
	 * @param sta
	 * @return
	 */
	Integer UpdateQingJia(Statistics sta);
	
	/**
	 * ����id��ѯ
	 * @param uid
	 * @return
	 */
	Statistics SelectById(Integer uid);
	
	/**
	 * ����idɾ��
	 * @param uid
	 * @return
	 */
	Integer DeleteById(Integer uid);
	
	/**
	 * ��ѯ����
	 * @return
	 */
	List<Statistics> SelectStatistics();
	
	
}

package com.lzb.service;

import org.jfree.chart.JFreeChart;

import com.lzb.entity.Statistics;

public interface StatisticsService {

	//ǩ������
	Integer UpdateQianDao(Statistics sta);
	
	//�ٵ�
	Integer UpdateChiDao(Statistics sta);
	
	//���
	Integer UpdateQingJia(Statistics sta);
	
	//����id��ѯ
	Statistics SelectById(Integer uid);
	
	//����idɾ��
	Integer DeleteById(Integer uid);
	
	//��״ͼ
	public JFreeChart createColumnarTools();
	
	//����ͼ
	public JFreeChart createFoldLineTools();
	
	//��״ͼ
	public JFreeChart createPieTools();
}

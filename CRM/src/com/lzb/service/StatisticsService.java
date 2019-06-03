package com.lzb.service;

import org.jfree.chart.JFreeChart;

import com.lzb.entity.Statistics;

public interface StatisticsService {

	//签到计数
	Integer UpdateQianDao(Statistics sta);
	
	//迟到
	Integer UpdateChiDao(Statistics sta);
	
	//请假
	Integer UpdateQingJia(Statistics sta);
	
	//根据id查询
	Statistics SelectById(Integer uid);
	
	//根据id删除
	Integer DeleteById(Integer uid);
	
	//柱状图
	public JFreeChart createColumnarTools();
	
	//折线图
	public JFreeChart createFoldLineTools();
	
	//饼状图
	public JFreeChart createPieTools();
}

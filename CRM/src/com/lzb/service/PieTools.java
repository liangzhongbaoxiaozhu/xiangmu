package com.lzb.service;

import java.awt.Font;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.labels.StandardPieSectionLabelGenerator;
import org.jfree.chart.plot.PiePlot3D;
import org.jfree.data.general.DefaultPieDataset;

public class PieTools {
	/**
	 * ������״ͼ
	 * @param dataset ��״ͼ����Դ
	 * @return
	 */
	public static JFreeChart createPie(DefaultPieDataset  dataset){
	    //������״ͼ
	    JFreeChart chart =ChartFactory.createPieChart3D("ռ�ȷ���", dataset, true, true, true);
	    //Ϊ��״ͼ��������
	    getChartByFont(chart);      
	    return chart;
	}
	/**
	 * �����״ͼ������
	 * @param chart
	 */
	private static void getChartByFont(JFreeChart chart){
	    //����ͼ���ϵ�����
	            //���������������
	            chart.getTitle().setFont(new Font("����",Font.BOLD,18));
	            //�����ӱ�������
	            chart.getLegend().setItemFont(new Font("����",Font.BOLD,15));
	            //��ȡͼ���������
	            PiePlot3D categoryPlot = (PiePlot3D)chart.getPlot();
	            //����ͼ���ϵ�����
	            categoryPlot.setLabelFont(new Font("����",Font.BOLD,15));
	            //����ͼ�ε����ɸ�ʽΪ������  23 ��10%���������� ֵ �ٷֱȣ�
	            String fm = "{0} {1} ({2})";
	            categoryPlot.setLabelGenerator(new StandardPieSectionLabelGenerator(fm));
	}
}

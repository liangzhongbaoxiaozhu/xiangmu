package com.lzb.service;

import java.awt.Font;

import org.jfree.chart.ChartColor;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.ValueAxis;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.BarRenderer;
import org.jfree.chart.title.TextTitle;
import org.jfree.data.category.CategoryDataset;

public class ColumnarTools {
	//����һ����״ͼ

	 //@param dataset
	          //��״ͼ����
	 // @return

	public static JFreeChart createCoColumnar(CategoryDataset dataset) {
	    // ������״ͼ
	    JFreeChart chart = ChartFactory.createBarChart3D("�����ǩ��ͳ��", // ͼ�����
	            "Ա��", // x�����ʾ��ǩ
	            "����", // y�����ʾ��ǩ
	            dataset, // ����
	            PlotOrientation.VERTICAL, // ͼ����ˮƽ����ֱ
	            true, // ��ʾͼ��
	            true, // ���ɹ���
	            true // URL����
	            );
	    // ������ͼ������������״ͼ����ɫ��������
	    chart.setBackgroundPaint(ChartColor.WHITE); // �����ܵı�����ɫ
	    // ���ͼ�ζ��󣬲�ͨ���˶����ͼ�ε���ɫ���ֽ�������
	    CategoryPlot polt = chart.getCategoryPlot();// ���ͼ�����
	    polt.setBackgroundPaint(ChartColor.lightGray);// ͼ�α�����ɫ
	    polt.setRangeGridlinePaint(ChartColor.WHITE);// ͼ�α����ɫ
	    // ���������
	    BarRenderer renderer = (BarRenderer) polt.getRenderer();
	    renderer.setMaximumBarWidth(0.06);
	    renderer.setBaseItemLabelGenerator(new StandardCategoryItemLabelGenerator());
	    renderer.setBaseItemLabelsVisible(true);
	    renderer.setBaseItemLabelFont(new Font("����", Font.BOLD, 15));
	    // ��������
	    getChartByFont(chart);

	    return chart;

	}


	//��״ͼ����������ʽ
	//
	// @param chart

	private static void getChartByFont(JFreeChart chart) {
	    // ͼ�����ñ�������
	    TextTitle textTitle = chart.getTitle();
	    textTitle.setFont(new Font("����", Font.BOLD, 20));

	    // ����ͼ��X����������
	    CategoryPlot plot = (CategoryPlot) chart.getPlot();
	    CategoryAxis axis = plot.getDomainAxis();
	    axis.setLabelFont(new Font("����", Font.BOLD, 22)); // ����X�������ϱ��������
	    axis.setTickLabelFont(new Font("����", Font.BOLD, 15)); // ����X�������ϵ�����

	    // ����ͼ��Y����������
	    ValueAxis valueAxis = plot.getRangeAxis();
	    valueAxis.setLabelFont(new Font("����", Font.BOLD, 12)); // ����Y�������ϱ��������
	    valueAxis.setTickLabelFont(new Font("sans-serif", Font.BOLD, 12));// ����Y�������ϵ�����
	    // ������ʾ���ݵ�����
	    chart.getLegend().setItemFont(new Font("����", Font.BOLD, 15));
	}
}

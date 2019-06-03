package com.lzb.service;

import java.awt.Font;
import java.awt.Rectangle;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.axis.CategoryAxis;
import org.jfree.chart.axis.NumberAxis;
import org.jfree.chart.axis.NumberTickUnit;
import org.jfree.chart.labels.StandardCategoryItemLabelGenerator;
import org.jfree.chart.plot.CategoryPlot;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.renderer.category.LineAndShapeRenderer;
import org.jfree.data.category.DefaultCategoryDataset;

public class FoldLineTools {
	/**
	 * ����һ������ͼ
	 * 
	 * @return
	 */
	public static JFreeChart createFoldLine(DefaultCategoryDataset dataset) {
	    JFreeChart chart = ChartFactory.createLineChart("ҵ������", "�·�", "ҵ����Ԫ��",
	            dataset, PlotOrientation.VERTICAL, true, true, true);
	    // ���ݵ����� �����ߵ�����
	    int datasetSize = dataset.getRowCount();
	    System.out.println(datasetSize);
	    getChartByFont(chart, datasetSize);

	    return chart;

	}

	/**
	 * ��������ͼ�ϵ�����
	 * 
	 * @param chart
	 * @param datasetSize
	 *            ���ݵ����� �����ߵ�����
	 */
	private static void getChartByFont(JFreeChart chart, int datasetSize) {
	    // ���������������
	    chart.getTitle().setFont(new Font("����", Font.BOLD, 18));
	    // �����ӱ�������
	    chart.getLegend().setItemFont(new Font("����", Font.BOLD, 15));
	    // ��ȡͼ������
	    CategoryPlot categoryPlot = (CategoryPlot) chart.getPlot();
	    // ��ȡX��
	    CategoryAxis categoryAxis = (CategoryAxis) categoryPlot.getDomainAxis();
	    // ��ȡY��
	    NumberAxis numberAxis = (NumberAxis) categoryPlot.getRangeAxis();
	    // ����X���ϵ�����
	    categoryAxis.setTickLabelFont(new Font("����", Font.BOLD, 12));
	    // ����X���������
	    categoryAxis.setLabelFont(new Font("����", Font.BOLD, 12));
	    // ����Y���ϵ�����
	    numberAxis.setTickLabelFont(new Font("����", Font.BOLD, 15));
	    // ����Y���������
	    numberAxis.setLabelFont(new Font("����", Font.BOLD, 15));
	    // ����Y������ʾ�Ŀ̶ȣ���5000��Ϊ1��
	    numberAxis.setAutoTickUnitSelection(false);
	    NumberTickUnit unit = new NumberTickUnit(5000);
	    numberAxis.setTickUnit(unit);
	    // ��ȡ��ͼ����
	    LineAndShapeRenderer lineAndShapeRenderer = (LineAndShapeRenderer) categoryPlot
	            .getRenderer();
	    // ��ͼ������ʾ����
	    lineAndShapeRenderer
	            .setBaseItemLabelGenerator(new StandardCategoryItemLabelGenerator());
	    lineAndShapeRenderer.setBaseItemLabelsVisible(true);
	    lineAndShapeRenderer
	            .setBaseItemLabelFont(new Font("����", Font.BOLD, 10));
	    // ��ͼ�������ת�۵㣨С���Σ�
	    Rectangle shape = new Rectangle(5, 5);
	    for (int i = 0; i < datasetSize; i++) {
	        lineAndShapeRenderer.setSeriesShape(i, shape);
	        lineAndShapeRenderer.setSeriesShapesVisible(i, true);
	    }
	}
}

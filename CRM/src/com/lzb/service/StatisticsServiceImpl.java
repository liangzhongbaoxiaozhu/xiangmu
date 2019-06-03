package com.lzb.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.jfree.chart.JFreeChart;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.DefaultPieDataset;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lzb.dao.Statisticsdao;
import com.lzb.entity.Statistics;

@Service
public class StatisticsServiceImpl implements StatisticsService{

	@Autowired
	private Statisticsdao statisticsdao;
	
	@Override
	public Integer UpdateQianDao(Statistics sta) {
		// TODO Auto-generated method stub
		return statisticsdao.UpdateQianDao(sta);
	}

	@Override
	public Integer UpdateChiDao(Statistics sta) {
		// TODO Auto-generated method stub
		return statisticsdao.UpdateChiDao(sta);
	}

	@Override
	public Integer UpdateQingJia(Statistics sta) {
		// TODO Auto-generated method stub
		return statisticsdao.UpdateQingJia(sta);
	}

	@Override
	public Statistics SelectById(Integer uid) {
		// TODO Auto-generated method stub
		return statisticsdao.SelectById(uid);
	}

	@Override
	public Integer DeleteById(Integer uid) {
		// TODO Auto-generated method stub
		return statisticsdao.DeleteById(uid);
	}

	
	//����״ͼ�����������ȡ������Columnar��״ͼ

	public JFreeChart createColumnarTools() {
	    // TODO Auto-generated method stub
		
	    // �������
	    CategoryDataset dataset = getDataSet1();
	    // ��ȡ��״ͼ�����ഴ������״ͼ���������ݼ����룩
	    JFreeChart chart = ColumnarTools.createCoColumnar(dataset);
	    return chart;
	}

	 //��ȡһ����ʾ�õ�������ݼ����� Ϊ��״ͼ�������
	
	private  CategoryDataset getDataSet1() {
		//��ȡ����
		List<Statistics> selectStatistics = statisticsdao.SelectStatistics();
		
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
	    // ���ݿ��Դ����ݿ��еõ�
		for(Statistics s:selectStatistics){
			dataset.addValue(s.getQiandao(), "ǩ��", s.getName());
			dataset.addValue(s.getQingjia(), "���", s.getName());
			dataset.addValue(s.getChidao(), "�ٵ�", s.getName());
		}
	    
	    
	    return dataset;
	}
	
	
	/**
	 * ������ͼ�������л�ȡ������ɵ�����ͼ
	 */
	public JFreeChart createFoldLineTools() {
	    // TODO Auto-generated method stub
	    //��ȡ����ͼ����Դ
	    DefaultCategoryDataset dataset=getDataSet();
	    //������ͼ�������л�ȡ������ɵ�����ͼ
	    JFreeChart chart=FoldLineTools.createFoldLine(dataset);

	    return chart;
	}
	/**
	 * Ϊ����ͼ��������
	 * @return
	 */
	public static DefaultCategoryDataset getDataSet(){
	    //�������ݼ�
	    DefaultCategoryDataset dataset=new DefaultCategoryDataset();
	    //�������
	    dataset.addValue(15636.36, "����", "һ��");
	    dataset.addValue(10001.36, "����", "����");
	    dataset.addValue(8856.20, "����", "����");
	    dataset.addValue(5964.26, "����", "����");
	    dataset.addValue(12365.23, "����", "һ��");
	    dataset.addValue(20056.12, "����", "����");
	    dataset.addValue(7896.36, "����", "����");
	    dataset.addValue(23005.45, "����", "����");
	    return dataset;

	}
	
	
	
	/**
	 * �ӱ�״ͼ�����������ȡ������Columnar��״ͼ
	 */
	public JFreeChart createPieTools() {
	    // TODO Auto-generated method stub
	    // ��ȡ��״ͼ�����ݼ�
	    DefaultPieDataset dataset = getDataSet2();
	    // ��ȡ��״ͼ�����ഴ���ı�״ͼ
	    JFreeChart chart = PieTools.createPie(dataset);
	    return chart;
	}

	/**
	 * ��ӱ�״ͼ������
	 * 
	 * @return
	 */
	private  DefaultPieDataset getDataSet2() {
		//��ȡ����
		List<Statistics> selectStatistics = statisticsdao.SelectStatistics();
		int chidao=0;
		for(Statistics s:selectStatistics){
			chidao=chidao+s.getChidao();
		}
		int zhengchang=0;
		for(Statistics s:selectStatistics){
			zhengchang=zhengchang+s.getQiandao();
		}
		int qingjia=0;
		for(Statistics s:selectStatistics){
			qingjia=qingjia+s.getQingjia();
		}
	    // ���ݿ��Դ����ݿ��еõ�
	    DefaultPieDataset dataset = new DefaultPieDataset();
	    // �������
	   /* System.out.println(chidao+","+zhengchang+","+qingjia);*/
	    Map<String, Double> map = new HashMap<String, Double>();
	    map.put("�ٵ�", (double) chidao);
	    map.put("����", (double) zhengchang);
	    map.put("���", (double) qingjia);
	   
	    Double sum = 0.0;
	    int count = map.size();
	    Set<String> keys = map.keySet();
	    for (String key : keys) {
	        sum += sum + map.get(key);

	    }
	    for (String key : keys) {

	        dataset.setValue(key, map.get(key));
	    }
	    // dataset.setValue("����",30);
	    // dataset.setValue("����",12);
	    // dataset.setValue("����",12);
	    // dataset.setValue("����",10);

	    return dataset;

	}
}

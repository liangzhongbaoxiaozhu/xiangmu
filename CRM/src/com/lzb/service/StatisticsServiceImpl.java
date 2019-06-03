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

	
	//从柱状图工具类里面获取创建的Columnar柱状图

	public JFreeChart createColumnarTools() {
	    // TODO Auto-generated method stub
		
	    // 获得数据
	    CategoryDataset dataset = getDataSet1();
	    // 获取柱状图工具类创建的柱状图，（将数据集传入）
	    JFreeChart chart = ColumnarTools.createCoColumnar(dataset);
	    return chart;
	}

	 //获取一个演示用的组合数据集对象 为柱状图添加数据
	
	private  CategoryDataset getDataSet1() {
		//获取所有
		List<Statistics> selectStatistics = statisticsdao.SelectStatistics();
		
		DefaultCategoryDataset dataset = new DefaultCategoryDataset();
	    // 数据可以从数据库中得到
		for(Statistics s:selectStatistics){
			dataset.addValue(s.getQiandao(), "签到", s.getName());
			dataset.addValue(s.getQingjia(), "请假", s.getName());
			dataset.addValue(s.getChidao(), "迟到", s.getName());
		}
	    
	    
	    return dataset;
	}
	
	
	/**
	 * 从折线图工具类中获取创建完成的折线图
	 */
	public JFreeChart createFoldLineTools() {
	    // TODO Auto-generated method stub
	    //获取折线图数据源
	    DefaultCategoryDataset dataset=getDataSet();
	    //从折线图工具类中获取创建完成的折线图
	    JFreeChart chart=FoldLineTools.createFoldLine(dataset);

	    return chart;
	}
	/**
	 * 为折线图创建数据
	 * @return
	 */
	public static DefaultCategoryDataset getDataSet(){
	    //创建数据集
	    DefaultCategoryDataset dataset=new DefaultCategoryDataset();
	    //添加数据
	    dataset.addValue(15636.36, "张三", "一月");
	    dataset.addValue(10001.36, "张三", "二月");
	    dataset.addValue(8856.20, "张三", "三月");
	    dataset.addValue(5964.26, "张三", "四月");
	    dataset.addValue(12365.23, "李四", "一月");
	    dataset.addValue(20056.12, "李四", "二月");
	    dataset.addValue(7896.36, "李四", "三月");
	    dataset.addValue(23005.45, "李四", "四月");
	    return dataset;

	}
	
	
	
	/**
	 * 从饼状图工具类里面获取创建的Columnar柱状图
	 */
	public JFreeChart createPieTools() {
	    // TODO Auto-generated method stub
	    // 获取饼状图的数据集
	    DefaultPieDataset dataset = getDataSet2();
	    // 获取饼状图工具类创建的饼状图
	    JFreeChart chart = PieTools.createPie(dataset);
	    return chart;
	}

	/**
	 * 添加饼状图的数据
	 * 
	 * @return
	 */
	private  DefaultPieDataset getDataSet2() {
		//获取所有
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
	    // 数据可以从数据库中得到
	    DefaultPieDataset dataset = new DefaultPieDataset();
	    // 添加数据
	   /* System.out.println(chidao+","+zhengchang+","+qingjia);*/
	    Map<String, Double> map = new HashMap<String, Double>();
	    map.put("迟到", (double) chidao);
	    map.put("正常", (double) zhengchang);
	    map.put("请假", (double) qingjia);
	   
	    Double sum = 0.0;
	    int count = map.size();
	    Set<String> keys = map.keySet();
	    for (String key : keys) {
	        sum += sum + map.get(key);

	    }
	    for (String key : keys) {

	        dataset.setValue(key, map.get(key));
	    }
	    // dataset.setValue("张三",30);
	    // dataset.setValue("李四",12);
	    // dataset.setValue("李四",12);
	    // dataset.setValue("王六",10);

	    return dataset;

	}
}

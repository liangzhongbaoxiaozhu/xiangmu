package com.lzb.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.jfree.chart.JFreeChart;
import org.jfree.chart.servlet.ServletUtilities;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.lzb.service.StatisticsService;

@Controller
public class StatisticsController {

	@Autowired
	private StatisticsService statisticsService;
	
	@RequestMapping(value = "/getColumnChart")
	public ModelAndView getColumnChart(HttpServletRequest request,
	        HttpServletResponse response, ModelMap modelMap) throws Exception {
	    // 在业务层获取创建的柱状图（此时柱状图已经创建完成的）
	    JFreeChart chart = statisticsService.createColumnarTools();
	    // 将图形转换为图片传到dateSet.jsp
	    String fileName = ServletUtilities.saveChartAsJPEG(chart, 700, 400,
	            null, request.getSession());
	    String chartURL = request.getContextPath() + "/chart?filename="+ fileName;
	    modelMap.put("chartColumnURL", chartURL);
	    return new ModelAndView("Statistics", modelMap);
	}
	
	@RequestMapping(value = "/getLineChart")
	public ModelAndView getLineChart(HttpServletRequest request,
	        HttpServletResponse response, ModelMap modelMap) throws Exception {
	    // 在业务层获取创建的折线图（此时折线图已经创建完成的）
	    JFreeChart chart = statisticsService.createFoldLineTools();
	    // 将图形转换为图片传到dateSet.jsp
	    String fileName = ServletUtilities.saveChartAsJPEG(chart, 700, 400,
	            null, request.getSession());
	    String chartURL = request.getContextPath() + "/chart?filename="+ fileName;
	    modelMap.put("chartLineURL", chartURL);
	    return new ModelAndView("Statistics", modelMap);
	}
	
	@RequestMapping(value = "/getPieChart")
	public ModelAndView getPieChart(HttpServletRequest request,
	        HttpServletResponse response, ModelMap modelMap) throws Exception {
	    // 在业务层获取创建的折线图（此时折线图已经创建完成的）
	    JFreeChart chart = statisticsService.createPieTools();
	    // 将图形转换为图片传到dateSet.jsp
	    String fileName = ServletUtilities.saveChartAsJPEG(chart, 700, 400,
	            null, request.getSession());
	    String chartURL = request.getContextPath() + "/chart?filename="+ fileName;
	    modelMap.put("chartPieURL", chartURL);
	    return new ModelAndView("Statistics", modelMap);
	}
}

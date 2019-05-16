package com.lzb.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lzb.entity.FenYe;
import com.lzb.entity.Students;
import com.lzb.service.StudentsService;
@Controller
public class StudentsController {
    @Autowired
	private StudentsService studentsService;
	
    @RequestMapping(value="/aaa",method=RequestMethod.POST)
	@ResponseBody
	public FenYe selectStu(Integer page,Integer rows,
	String sname,String smtel,String zixunshi,String QQ,String startData,String endData,String isPay,String isEffective,String isReturnVisit) {
    	FenYe fenye=new FenYe();
		fenye.setPage((page-1)*rows);
		fenye.setPageSize(rows);
		fenye.setSname(sname);
		fenye.setSmtel(smtel);
		fenye.setZixunshi(zixunshi);
		fenye.setQQ(QQ);
		fenye.setStartData(startData);
		fenye.setEndData(endData);
		fenye.setIsPay(isPay);
		fenye.setIsEffective(isEffective);
		fenye.setIsReturnVisit(isReturnVisit);
		fenye=studentsService.selectStu(fenye);
		return fenye;
	}
	
    @RequestMapping(value="/GeRen",method=RequestMethod.POST)
	@ResponseBody
	public FenYe selectStuGeRen(Integer page,Integer rows,Integer uid,
	String sname,String smtel,String zixunshi,String QQ,String startData,String endData,String isPay,String isEffective,String isReturnVisit) {
    	FenYe fenye=new FenYe();
		fenye.setPage((page-1)*rows);
		fenye.setPageSize(rows);
		fenye.setJiaoXueid(uid);
		fenye.setSname(sname);
		fenye.setSmtel(smtel);
		fenye.setZixunshi(zixunshi);
		fenye.setQQ(QQ);
		fenye.setStartData(startData);
		fenye.setEndData(endData);
		fenye.setIsPay(isPay);
		fenye.setIsEffective(isEffective);
		fenye.setIsReturnVisit(isReturnVisit);
		fenye=studentsService.selectStuGeRen(fenye);
		return fenye;
	}
    
    /*@RequestMapping(value="/updateStu",method=RequestMethod.POST)
    @ResponseBody
    public Integer updateStu(Students students){
    	return studentsService.updateStu(students);
    }*/
    @RequestMapping(value="/updateStu",method=RequestMethod.POST)
    @ResponseBody
    public Integer updateStu(Students students) {
    	return studentsService.updateStu(students);
    }
    @RequestMapping(value="/addStu",method=RequestMethod.POST)
    @ResponseBody
    public Integer insertStu(Students students) {
    	return studentsService.insertStu(students);
    }
    
    @RequestMapping(value="/deleteStu",method=RequestMethod.POST)
    @ResponseBody
    public Integer deleteStu(Integer sid) {
    	return studentsService.deleteStu(sid);
    }
    
    
    
    
    
}

package com.lzb.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lzb.entity.FenYe;
import com.lzb.entity.Students;
import com.lzb.entity.Track;
import com.lzb.entity.Users;
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
    	return studentsService.updateStu(students);SelectCountDengJi
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
    
    //添加日志
    @RequestMapping(value="/Insertrizhi",method=RequestMethod.POST)
    @ResponseBody
    public Integer Insertrizhi(Track track) {
    	Integer updateTrack = studentsService.InsertTrack(track);
    	return updateTrack;
    }
    
    
  //查看日志
    @RequestMapping(value="/selectrizi",method=RequestMethod.POST)
    @ResponseBody
    public FenYe selectrizi(Integer page,Integer rows,Integer uid) {
    	FenYe fen=new FenYe();
		fen.setPage((page-1)*rows);
		fen.setPageSize(rows);
		fen.setSid(uid);
		FenYe selectTrackstu = studentsService.SelectTrackstu(fen);
    	return selectTrackstu;
    }
  //查询所有咨询师
    @RequestMapping(value="/selectZiXunShi",method=RequestMethod.POST)
    @ResponseBody
    public List<Users> selectZiXunShi() {
    	List<Users> selectChaXunZiXunShi = studentsService.SelectChaXunZiXunShi();
    	
    	return selectChaXunZiXunShi;
    }  
    //修改学生的咨询师
    @RequestMapping(value="/updateXueShengZiXunShi",method=RequestMethod.POST)
    @ResponseBody
    public Integer  updateXueShengZiXunShi(Integer uid,String sid) {
    	FenYe fen=new FenYe();
    	
    	fen.setPageSize(uid);
    	String[] split = sid.split(",");
    	Integer updateXueShengZiXunShi=1;
    	for(int i=0;i<split.length;i++){
    		/*System.out.println(split[i]);*/
    		if(split[i]!=null){
    			fen.setPage(Integer.parseInt(split[i]));
        		updateXueShengZiXunShi= studentsService.UpdateXueShengZiXunShi(fen); 
        		if(updateXueShengZiXunShi<1){
        			return 0;
        		}
    		}else{
    			
    		}
    	}
    	
    	return updateXueShengZiXunShi;
    }     
    @RequestMapping(value="/daochuexcel")
	@ResponseBody
	public void daochuexcel(HttpServletRequest request,HttpServletResponse response,String s_ids) throws IOException {
    	studentsService.daochuexcel(request, response, s_ids);
	}
}

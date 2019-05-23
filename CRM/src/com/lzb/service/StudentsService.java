package com.lzb.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lzb.entity.FenYe;
import com.lzb.entity.Students;
import com.lzb.entity.Tips;
import com.lzb.entity.Track;
import com.lzb.entity.Users;

public interface StudentsService {
    
	FenYe selectStu(FenYe fenye);
	
	Integer updateStu(Students students);
	
	Integer insertStu(Students students);
	
	Integer deleteStu(Integer sid);
	
	List<Students> selectStuQuanBu();
	
	    //个人的学生
		FenYe selectStuGeRen(FenYe fenye);
		
		//添加日志
		Integer InsertTrack(Track track);
		
		/*多条件分页查询*/
		FenYe SelectTrackstu(FenYe fen);
		
		//查询所有咨询师
		List<Users> SelectChaXunZiXunShi();
		
		//给学生修改咨询师
		Integer UpdateXueShengZiXunShi(FenYe fen);
		
		//导出excl表格
		void daochuexcel(HttpServletRequest request, HttpServletResponse response, String s_id);
		
		//添加提醒消息
		Integer IntegerTips(Tips tips);
		
		//根据id查询消息
		List<Tips> selectTips(Integer tid);
		
		//根据id删除
		Integer deleteTips(Integer tid);
}

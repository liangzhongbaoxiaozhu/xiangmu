package com.lzb.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lzb.entity.FenYe;
import com.lzb.entity.Students;
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
		
		
		/**
		 * 添加日志
		 * @param track
		 * @return
		 */
		Integer InsertTrack(Track track);
		
		/*多条件分页查询*/
		FenYe SelectTrackstu(FenYe fen);
		/**
		 * 查询所有咨询师
		 * @return
		 */
		List<Users> SelectChaXunZiXunShi();
		/**
		 * 给学生修改咨询师
		 * @return
		 */
		Integer UpdateXueShengZiXunShi(FenYe fen);
		//导出excl表格
		void daochuexcel(HttpServletRequest request, HttpServletResponse response, String s_id);
		
}

package com.lzb.service;

import java.util.List;

import com.lzb.entity.FenYe;
import com.lzb.entity.Students;
import com.lzb.entity.Track;

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
		
}

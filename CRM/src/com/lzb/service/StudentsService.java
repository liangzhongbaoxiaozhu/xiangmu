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
	
	    //���˵�ѧ��
		FenYe selectStuGeRen(FenYe fenye);
		
		
		/**
		 * �����־
		 * @param track
		 * @return
		 */
		Integer InsertTrack(Track track);
		
		/*��������ҳ��ѯ*/
		FenYe SelectTrackstu(FenYe fen);
		
}

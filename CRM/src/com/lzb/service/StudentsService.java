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
		/**
		 * ��ѯ������ѯʦ
		 * @return
		 */
		List<Users> SelectChaXunZiXunShi();
		/**
		 * ��ѧ���޸���ѯʦ
		 * @return
		 */
		Integer UpdateXueShengZiXunShi(FenYe fen);
		//����excl���
		void daochuexcel(HttpServletRequest request, HttpServletResponse response, String s_id);
		
}

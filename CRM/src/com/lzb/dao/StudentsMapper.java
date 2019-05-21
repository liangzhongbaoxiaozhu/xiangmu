package com.lzb.dao;

import java.util.List;

import com.lzb.entity.FenYe;
import com.lzb.entity.Students;
import com.lzb.entity.Track;
import com.lzb.entity.Users;

public interface StudentsMapper {
    
	Integer selectStuCounta(FenYe fenye);
	
	List<Students> selectStu(FenYe fenye);
	
	Integer updateStu(Students students);
	
	Integer deleteStu(Integer sid);
	
	Integer insertStu(Students students);
	List<Students> selectStuQuanBu();
	//��������
	Integer PiLiangCaoZuo();
	//���˵�ѧ��
	List<Students> selectStuGeRen(FenYe fenye);
	//���˵�ѧ������
	Integer selectStuCountGeRen(FenYe fenye);
	/**
	 * �����־
	 * @param track
	 * @return
	 */
	Integer InsertTrack(Track track);
	
	/*��������ҳ��ѯ*/
	List<Track> SelectTrackstu(FenYe fen);
	/*��ѯ������*/
	Integer SelectCountstu(FenYe fen);
	/**
	 * ��ѯ�ȼ�
	 * @return
	 */
	List<Users> selectFenLianDengji(FenYe fen);
	/**
	 * ��ѯ�ȼ�����
	 * @param dengji
	 * @return
	 */
	Integer SelectCountDengJi(FenYe fen);
	/**
	 * ������޸�����
	 * @param fen
	 * @return
	 */
	Integer updateFenLiangDengJi(FenYe fen);
	/**
	 * �޸�ȫ��
	 * @return
	 */
	Integer UpdateFenLiangQuanBu();
	
}

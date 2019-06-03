package com.lzb.dao;

import java.util.List;

import com.lzb.entity.FenYe;
import com.lzb.entity.Students;
import com.lzb.entity.Tips;
import com.lzb.entity.Track;
import com.lzb.entity.Users;

public interface StudentsMapper {
    
	Integer selectStuCounta(FenYe fenye);
	
	List<Students> selectStu(FenYe fenye);
	
	Integer updateStu(Students students);
	
	Integer deleteStu(Integer sid);
	
	Integer insertStu(Students students);
	
	List<Students> selectStuQuanBu();
	
	/**
	 * ��������
	 * @return
	 */
	Integer PiLiangCaoZuo();
	
	/**
	 * ���˵�ѧ��
	 * @param fenye
	 * @return
	 */
	List<Students> selectStuGeRen(FenYe fenye);
	
	/**
	 * ���˵�ѧ������
	 * @param fenye
	 * @return
	 */
	Integer selectStuCountGeRen(FenYe fenye);
	
	/**
	 * ��·��ѯʦ��ѧ��
	 * @param fenye
	 * @return
	 */
	List<Students> selectStuwangluo(FenYe fenye);
	
	/**
	 * ������ѯʦ��ѧ������
	 * @param fenye
	 * @return
	 */
	Integer selectStuCountwangluo(FenYe fenye);
	
	/**
	 * �����־
	 * @param track
	 * @return
	 */
	Integer InsertTrack(Track track);
	
	/**
	 * ������ҳ��ѯ
	 * @param fen
	 * @return
	 */
	List<Track> SelectTrackstu(FenYe fen);
	
	/**
	 * ��ѯ������
	 * @param fen
	 * @return
	 */
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
	 * ����״̬
	 * @return
	 */
	String SelectFenLiangShiFouKaiQi();
	
	/**
	 * �޸�ȫ��
	 * @return
	 */
	Integer UpdateFenLiangQuanBu();
	
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
	
	/**
	 * ����id��list��ѯѧ��
	 * @param list
	 * @return
	 */
	List<Students> selectStudent_xuanzhong(List list);
	
}

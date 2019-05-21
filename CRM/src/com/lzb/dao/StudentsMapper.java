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
	//批量操作
	Integer PiLiangCaoZuo();
	//个人的学生
	List<Students> selectStuGeRen(FenYe fenye);
	//个人的学生数量
	Integer selectStuCountGeRen(FenYe fenye);
	/**
	 * 添加日志
	 * @param track
	 * @return
	 */
	Integer InsertTrack(Track track);
	
	/*多条件分页查询*/
	List<Track> SelectTrackstu(FenYe fen);
	/*查询总条数*/
	Integer SelectCountstu(FenYe fen);
	/**
	 * 查询等级
	 * @return
	 */
	List<Users> selectFenLianDengji(FenYe fen);
	/**
	 * 查询等级数量
	 * @param dengji
	 * @return
	 */
	Integer SelectCountDengJi(FenYe fen);
	/**
	 * 添加完修改条件
	 * @param fen
	 * @return
	 */
	Integer updateFenLiangDengJi(FenYe fen);
	/**
	 * 修改全部
	 * @return
	 */
	Integer UpdateFenLiangQuanBu();
	
}

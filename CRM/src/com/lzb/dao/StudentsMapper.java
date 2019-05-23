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
	 * 批量操作
	 * @return
	 */
	Integer PiLiangCaoZuo();
	
	/**
	 * 个人的学生
	 * @param fenye
	 * @return
	 */
	List<Students> selectStuGeRen(FenYe fenye);
	
	/**
	 * 个人的学生数量
	 * @param fenye
	 * @return
	 */
	Integer selectStuCountGeRen(FenYe fenye);
	
	/**
	 * 添加日志
	 * @param track
	 * @return
	 */
	Integer InsertTrack(Track track);
	
	/**
	 * 条件分页查询
	 * @param fen
	 * @return
	 */
	List<Track> SelectTrackstu(FenYe fen);
	
	/**
	 * 查询总条数
	 * @param fen
	 * @return
	 */
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
	 * 分量状态
	 * @return
	 */
	String SelectFenLiangShiFouKaiQi();
	
	/**
	 * 修改全部
	 * @return
	 */
	Integer UpdateFenLiangQuanBu();
	
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
	
	/**
	 * 根据id的list查询学生
	 * @param list
	 * @return
	 */
	List<Students> selectStudent_xuanzhong(List list);
	
}

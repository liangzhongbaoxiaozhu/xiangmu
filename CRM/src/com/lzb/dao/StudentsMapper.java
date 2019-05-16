package com.lzb.dao;

import java.util.List;

import com.lzb.entity.FenYe;
import com.lzb.entity.Students;

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
}

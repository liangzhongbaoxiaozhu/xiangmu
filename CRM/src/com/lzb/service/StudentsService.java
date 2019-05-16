package com.lzb.service;

import java.util.List;

import com.lzb.entity.FenYe;
import com.lzb.entity.Students;

public interface StudentsService {
    
	FenYe selectStu(FenYe fenye);
	
	Integer updateStu(Students students);
	
	Integer insertStu(Students students);
	
	Integer deleteStu(Integer sid);
	
	List<Students> selectStuQuanBu();
	
	    //个人的学生
		FenYe selectStuGeRen(FenYe fenye);
		
}

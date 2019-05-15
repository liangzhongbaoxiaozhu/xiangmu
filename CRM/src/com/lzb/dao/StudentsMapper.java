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
	
}

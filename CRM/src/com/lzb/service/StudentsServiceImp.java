package com.lzb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lzb.dao.StudentsMapper;
import com.lzb.entity.FenYe;
import com.lzb.entity.Students;
@Service
public class StudentsServiceImp implements StudentsService {
    @Autowired
	private StudentsMapper studentsMapper;
	
	@Override
	public FenYe selectStu(FenYe fenye) {
		Integer count = studentsMapper.selectStuCounta(fenye);
		List<Students> stu = studentsMapper.selectStu(fenye);
		fenye.setTotal(count);
		fenye.setRows(stu);
		return fenye;
	}

	

	@Override
	public Integer insertStu(Students students) {
		// TODO Auto-generated method stub
		return studentsMapper.insertStu(students);
	}

	@Override
	public Integer deleteStu(Integer sid) {
		// TODO Auto-generated method stub
		return studentsMapper.deleteStu(sid);
	}



	@Override
	public Integer updateStu(Students students) {
		// TODO Auto-generated method stub
		return studentsMapper.updateStu(students);
	}
    
	
}

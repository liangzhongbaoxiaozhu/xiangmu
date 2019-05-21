package com.lzb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lzb.dao.StudentsMapper;
import com.lzb.entity.FenYe;
import com.lzb.entity.Students;
import com.lzb.entity.Track;
import com.lzb.entity.Users;
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
		FenYe fen=new FenYe();
		
		for(int i=4;i>0;i--){
			fen.setPage(i);
			fen.setPageSize(0);
			Integer selectCountDengJi = studentsMapper.SelectCountDengJi(fen);
			if(i==1&&selectCountDengJi==1){
				studentsMapper.UpdateFenLiangQuanBu();
			}
			if(selectCountDengJi>0){
				/*System.out.println(i);*/
				List<Users> selectFenLianDengji = studentsMapper.selectFenLianDengji(fen);
				students.setConsultantId(selectFenLianDengji.get(0).getUid());
				fen.setPage(1);
				fen.setPageSize(selectFenLianDengji.get(0).getUid());
				studentsMapper.updateFenLiangDengJi(fen);
				/*System.out.println(selectFenLianDengji.get(0).getUid());*/
				break;
			}
			
			
    	}
		
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



	@Override
	public List<Students> selectStuQuanBu() {
		// TODO Auto-generated method stub
		List<Students> selectStuQuanBu = studentsMapper.selectStuQuanBu();
		return selectStuQuanBu;
	}



	@Override
	public FenYe selectStuGeRen(FenYe fenye) {
		// TODO Auto-generated method stub
		Integer selectStuCountGeRen = studentsMapper.selectStuCountGeRen(fenye);
		List<Students> selectStuGeRen = studentsMapper.selectStuGeRen(fenye);
		fenye.setTotal(selectStuCountGeRen);
		fenye.setRows(selectStuGeRen);
		return fenye;
	}



	@Override
	public Integer InsertTrack(Track track) {
		// TODO Auto-generated method stub
		return studentsMapper.InsertTrack(track);
	}



	@Override
	public FenYe SelectTrackstu(FenYe fen) {
		// TODO Auto-generated method stub
		fen.setRows(studentsMapper.SelectTrackstu(fen));
		fen.setTotal(studentsMapper.SelectCountstu(fen));
		return fen;
	}



	
    
	
}

package com.lzb.service;

import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.CellRangeAddress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lzb.dao.StudentsMapper;
import com.lzb.dao.Tipsdao;
import com.lzb.entity.FenYe;
import com.lzb.entity.Students;
import com.lzb.entity.Tips;
import com.lzb.entity.Track;
import com.lzb.entity.Users;
@Service
public class StudentsServiceImp implements StudentsService {
    @Autowired
	private StudentsMapper studentsMapper;
    @Autowired
	private Tipsdao tipsdao;
	
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
		String selectFenLiangShiFouKaiQi = studentsMapper.SelectFenLiangShiFouKaiQi();
		/*System.out.println(selectFenLiangShiFouKaiQi);*/
		if(Boolean.parseBoolean(selectFenLiangShiFouKaiQi)){
		FenYe fen=new FenYe();
		
		for(int i=4;i>0;i--){
			/*System.out.println("i="+i);*/
			fen.setPage(i);
			fen.setPageSize(0);
			Integer selectCountDengJi = studentsMapper.SelectCountDengJi(fen);
			/*System.out.println(selectCountDengJi);*/
			if(i==1&&selectCountDengJi==0){
				studentsMapper.UpdateFenLiangQuanBu();
				i=4;
				fen.setPage(i);
			}
			 selectCountDengJi = studentsMapper.SelectCountDengJi(fen);
			/* System.out.println(selectCountDengJi);*/
			if(selectCountDengJi>0){
				/*System.out.println(i);*/
				List<Users> selectFenLianDengji = studentsMapper.selectFenLianDengji(fen);
				/*System.out.println(selectFenLianDengji.get(0).getUid());*/
				students.setConsultantId(selectFenLianDengji.get(0).getUid());
				fen.setPage(1);
				fen.setPageSize(selectFenLianDengji.get(0).getUid());
				studentsMapper.updateFenLiangDengJi(fen);
				/*System.out.println(selectFenLianDengji.get(0).getUid());*/
				break;
			}
			
			
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



	@Override
	public List<Users> SelectChaXunZiXunShi() {
		// TODO Auto-generated method stub
		List<Users> selectChaXunZiXunShi = studentsMapper.SelectChaXunZiXunShi();
		return selectChaXunZiXunShi;
	}



	@Override
	public Integer UpdateXueShengZiXunShi(FenYe fen) {
		// TODO Auto-generated method stub
		Integer updateXueShengZiXunShi = studentsMapper.UpdateXueShengZiXunShi(fen);
		return updateXueShengZiXunShi;
	}



	@Override
	public void daochuexcel(HttpServletRequest request,
			HttpServletResponse response, String s_id) {
		// TODO Auto-generated method stub
		String[] split = s_id.split(",");
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < split.length; i++) {
			list.add(Integer.parseInt(split[i]));
		}
		List<Students> studentlist = studentsMapper.selectStudent_xuanzhong(list);
		

		// ����HSSFWorkbook����(excel���ĵ�����)
		HSSFWorkbook wkb = new HSSFWorkbook();
		// �����µ�sheet����excel�ı���
		HSSFSheet sheet = wkb.createSheet("ѧ����Ϣ");
		// ��sheet�ﴴ����һ�У�����Ϊ������(excel����)��������0��65535֮����κ�һ��
		HSSFRow row1 = sheet.createRow(0);
		// ������Ԫ��excel�ĵ�Ԫ�񣬲���Ϊ��������������0��255֮����κ�һ��
		HSSFCell cell = row1.createCell(0);
		// ���õ�Ԫ������
		cell.setCellValue("ѧ����Ϣ");
		// �ϲ���Ԫ��CellRangeAddress����������α�ʾ��ʼ�У������У���ʼ�У� ������
		sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, 3));
		// ��sheet�ﴴ���ڶ���

		HSSFRow row2 = sheet.createRow(1);
		// ������Ԫ�����õ�Ԫ������
		/*
		 * row2.createCell(0).setCellValue("sj_id");
		 * row2.createCell(1).setCellValue("sj_name");
		 * row2.createCell(2).setCellValue("sj_jage");
		 * row2.createCell(3).setCellValue("sj_zuozhe");
		 */

		String columnStr = "���������䣬�Ա𣬵绰��ѧ����״̬����Դ��������Դ��վ����Դ�ؼ��֣�"+ "qq��΢�ţ��Ƿ񱨱�����ע����ѯʦ������������Դ���ţ��γ̷����Ƿ���Ч����֣�" + "�Ƿ�طã��״λط�ʱ�䣬�Ƿ����ţ�����ʱ�䣬��Чԭ���Ƿ�ɷѣ��ɷ�ʱ�䣬���Ƿ��˷ѣ�"
				+ "�Ƿ���࣬����ʱ�䣬���౸ע���˷�ԭ�򣬶��������ʱ�䣬ѧ����ע��������ѯʦ����ѯʦ��ע";
		String[] heads = columnStr.split("��");
		for (int i = 0; i < heads.length; i++) {
			row2.createCell(i).setCellValue("" + heads[i] + "");
		}
		for (int i = 0; i < studentlist.size(); i++) {
			HSSFRow row3 = sheet.createRow(i + 2);
			Students stu = studentlist.get(i);
			row3.createCell(0).setCellValue(stu.getSname() == null ? "" : stu.getSname());
			row3.createCell(1).setCellValue(stu.getAge() == null ? 0 : stu.getAge());
			row3.createCell(2).setCellValue(stu.getSex() == null ? "" : "" + stu.getSex());
			row3.createCell(3).setCellValue(stu.getSmtel() == null ? "" : stu.getSmtel());
			row3.createCell(4).setCellValue(stu.getEducation() == null ? "" : stu.getEducation());
			row3.createCell(5).setCellValue(stu.getState() == null ? "" : stu.getState());
			row3.createCell(6).setCellValue(stu.getChannel() == null ? "" : stu.getChannel());
			row3.createCell(7).setCellValue(stu.getWebsite() == null ? "" : stu.getWebsite());
			row3.createCell(8).setCellValue(stu.getKeyWord() == null ? "" : stu.getKeyWord());
			row3.createCell(9).setCellValue(stu.getQq() == null ? "" : stu.getQq());
			row3.createCell(10).setCellValue(stu.getWeiXin() == null ? "" : stu.getWeiXin());
			row3.createCell(11).setCellValue(stu.getIsReport() == null ? "" : stu.getIsReport());
			row3.createCell(12).setCellValue(stu.getRemarks() == null ? "" : stu.getRemarks());
			row3.createCell(13).setCellValue(stu.getZixunshi() == null ? "������ѯʦ" : stu.getZixunshi());
			row3.createCell(14).setCellValue(stu.getRegion() == null ? "" : stu.getRegion());
			row3.createCell(15).setCellValue(stu.getDepartment() == null ? "" : stu.getDepartment());
			row3.createCell(16).setCellValue(stu.getCurriculum() == null ? "" : stu.getCurriculum());
			row3.createCell(17).setCellValue(stu.getIsEffective() == null ? "" : stu.getIsEffective() );
			row3.createCell(18).setCellValue(stu.getScoring()==null ? "" : stu.getScoring());
			row3.createCell(19).setCellValue(stu.getIsReturnVisit() == null ? "" : stu.getIsReturnVisit() );
			row3.createCell(20).setCellValue(stu.getReturnVisitData() == null ? "" : stu.getReturnVisitData());
			row3.createCell(21).setCellValue(stu.getDoor()== null ? "" : stu.getDoor());
			row3.createCell(22).setCellValue(stu.getDoorData() == null ? "" : stu.getDoorData());
			row3.createCell(23).setCellValue(stu.getReason() == null ? "" : stu.getReason());
			row3.createCell(24).setCellValue(stu.getIsPay() == null ? "" : stu.getIsPay());
			row3.createCell(25).setCellValue(stu.getPayData() == null ? "" : stu.getPayData());
			row3.createCell(26).setCellValue(stu.getMoney() == null ? 0 : stu.getMoney());
			row3.createCell(27).setCellValue(stu.getIsRefund() == null ? "" : stu.getIsRefund());
			row3.createCell(28).setCellValue(stu.getIsClassEntry() == null ? "" : stu.getIsClassEntry());
			row3.createCell(29).setCellValue(stu.getClassEntryData() == null ? "" : stu.getClassEntryData());
			row3.createCell(30).setCellValue(stu.getClassEntryRemarks() == null ? "" : stu.getClassEntryRemarks());
			row3.createCell(31).setCellValue(stu.getReasonsRefund() == null ? "" : stu.getReasonsRefund());
			row3.createCell(32).setCellValue(stu.getEarnestMoney() == null ? 0 : stu.getEarnestMoney());
			row3.createCell(33).setCellValue(stu.getEarnestMoneyData() == null ? "" : stu.getEarnestMoneyData());
			row3.createCell(34).setCellValue(stu.getFollow() == null ? "" : stu.getFollow());
			row3.createCell(35).setCellValue(stu.getLururen() == null ? "����������ѯʦ" : stu.getLururen());
			row3.createCell(36).setCellValue(stu.getConsultantRemarks() == null ? "" : stu.getConsultantRemarks());
		}
		// ���Excel�ļ�
		OutputStream output;
		try {
			output = response.getOutputStream();
			response.reset();
			response.setHeader("Content-disposition", "attachment; filename="+new String("ѧ����Ϣ.xls".getBytes("GB2312"),"ISO8859-1"));
			response.setContentType("application/msexcel");
			wkb.write(output);
			output.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}



	@Override
	public Integer IntegerTips(Tips tips) {
		// TODO Auto-generated method stub
		return tipsdao.IntegerTips(tips);
	}



	@Override
	public List<Tips> selectTips(Integer tid) {
		// TODO Auto-generated method stub
		return tipsdao.selectTips(tid);
	}



	@Override
	public Integer deleteTips(Integer tid) {
		// TODO Auto-generated method stub
		return tipsdao.deleteTips(tid);
	}



	
    
	
}

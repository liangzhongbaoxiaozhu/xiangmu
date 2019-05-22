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
		

		// 创建HSSFWorkbook对象(excel的文档对象)
		HSSFWorkbook wkb = new HSSFWorkbook();
		// 建立新的sheet对象（excel的表单）
		HSSFSheet sheet = wkb.createSheet("学生信息");
		// 在sheet里创建第一行，参数为行索引(excel的行)，可以是0～65535之间的任何一个
		HSSFRow row1 = sheet.createRow(0);
		// 创建单元格（excel的单元格，参数为列索引，可以是0～255之间的任何一个
		HSSFCell cell = row1.createCell(0);
		// 设置单元格内容
		cell.setCellValue("学生信息");
		// 合并单元格CellRangeAddress构造参数依次表示起始行，截至行，起始列， 截至列
		sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, 3));
		// 在sheet里创建第二行

		HSSFRow row2 = sheet.createRow(1);
		// 创建单元格并设置单元格内容
		/*
		 * row2.createCell(0).setCellValue("sj_id");
		 * row2.createCell(1).setCellValue("sj_name");
		 * row2.createCell(2).setCellValue("sj_jage");
		 * row2.createCell(3).setCellValue("sj_zuozhe");
		 */

		String columnStr = "姓名，年龄，性别，电话，学历，状态，来源渠道，来源网站，来源关键字，"+ "qq，微信，是否报备，备注，咨询师，所在区域，来源部门，课程方向，是否有效，打分，" + "是否回访，首次回访时间，是否上门，上门时间，无效原因，是否缴费，缴费时间，金额，是否退费，"
				+ "是否进班，进班时间，进班备注，退费原因，定金金额，定金时间，学生关注，网络咨询师，咨询师备注";
		String[] heads = columnStr.split("，");
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
			row3.createCell(13).setCellValue(stu.getZixunshi() == null ? "暂无咨询师" : stu.getZixunshi());
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
			row3.createCell(35).setCellValue(stu.getLururen() == null ? "暂无网络咨询师" : stu.getLururen());
			row3.createCell(36).setCellValue(stu.getConsultantRemarks() == null ? "" : stu.getConsultantRemarks());
		}
		// 输出Excel文件
		OutputStream output;
		try {
			output = response.getOutputStream();
			response.reset();
			response.setHeader("Content-disposition", "attachment; filename="+new String("学生信息.xls".getBytes("GB2312"),"ISO8859-1"));
			response.setContentType("application/msexcel");
			wkb.write(output);
			output.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}



	
    
	
}

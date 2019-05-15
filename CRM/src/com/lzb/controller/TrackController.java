package com.lzb.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.lzb.entity.FenYe;
import com.lzb.service.TrackService;

@Controller
public class TrackController {

	@Autowired
	private TrackService trackService;
	
	@RequestMapping(value="/TrackList",method={RequestMethod.POST})
	@ResponseBody
    public FenYe TrackList(Integer page,Integer rows,String studentName,String userName,
  	String trackStartData,String trackEndData,String returnVisit,String trackingMode) {
		FenYe fen=new FenYe();
		fen.setPage((page-1)*rows);
		fen.setPageSize(rows);
		fen.setStudentName(studentName);
		fen.setUserName(userName);
		fen.setTrackStartData(trackStartData);
		fen.setTrackEndData(trackEndData);
		fen.setReturnVisit(returnVisit);
		fen.setTrackingMode(trackingMode);
		/*System.out.println(trackStartData);
		System.out.println(trackEndData);
		System.out.println(returnVisit);
		System.out.println(trackingMode);*/
		//多条件查询
		fen = trackService.SelectTrack(fen);
		/*System.out.println(fen);*/
		
		return fen;
	}
}

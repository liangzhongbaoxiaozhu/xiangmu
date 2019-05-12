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
    public FenYe TrackList(Integer page,Integer rows) {
		FenYe fen=new FenYe();
		fen.setPage((page-1)*rows);
		fen.setPageSize(rows);
		
		//多条件查询
		fen = trackService.SelectTrack(fen);
		/*System.out.println(fen);*/
		
		return fen;
	}
}

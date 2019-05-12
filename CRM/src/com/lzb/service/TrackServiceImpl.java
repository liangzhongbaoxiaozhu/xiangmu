package com.lzb.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import com.lzb.dao.Trackdao;
import com.lzb.entity.FenYe;
import com.lzb.entity.Track;
@Component
public class TrackServiceImpl implements TrackService{

	@Autowired
	private Trackdao trackdao;
	@Override
	public FenYe SelectTrack(FenYe fen) {
		// TODO Auto-generated method stub
		fen.setRows(trackdao.SelectTrack(fen));
		fen.setTotal(trackdao.SelectCount(fen));
		return fen;
	}

}

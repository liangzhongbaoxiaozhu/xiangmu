package com.lzb.dao;

import java.util.List;

import com.lzb.entity.FenYe;
import com.lzb.entity.Track;

public interface Trackdao {

	/**
	 * 多条件分页查询
	 * @param fen
	 * @return
	 */
	List<Track> SelectTrack(FenYe fen);
	
	/**
	 * 查询总条数
	 * @param fen
	 * @return
	 */
	Integer SelectCount(FenYe fen);
}

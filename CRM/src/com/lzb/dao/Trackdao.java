package com.lzb.dao;

import java.util.List;

import com.lzb.entity.FenYe;
import com.lzb.entity.Track;

public interface Trackdao {

	/*多条件分页查询*/
	List<Track> SelectTrack(FenYe fen);
	/*查询总条数*/
	Integer SelectCount(FenYe fen);
}

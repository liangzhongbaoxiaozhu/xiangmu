package com.lzb.dao;

import java.util.List;

import com.lzb.entity.FenYe;
import com.lzb.entity.Track;

public interface Trackdao {

	/**
	 * ��������ҳ��ѯ
	 * @param fen
	 * @return
	 */
	List<Track> SelectTrack(FenYe fen);
	
	/**
	 * ��ѯ������
	 * @param fen
	 * @return
	 */
	Integer SelectCount(FenYe fen);
}

package com.lzb.dao;

import java.util.List;

import com.lzb.entity.FenYe;
import com.lzb.entity.Track;

public interface Trackdao {

	/*��������ҳ��ѯ*/
	List<Track> SelectTrack(FenYe fen);
	/*��ѯ������*/
	Integer SelectCount(FenYe fen);
}

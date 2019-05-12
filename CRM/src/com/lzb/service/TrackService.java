package com.lzb.service;

import java.util.List;

import com.lzb.entity.FenYe;
import com.lzb.entity.Track;

public interface TrackService {
	/*多条件分页查询*/
	FenYe SelectTrack(FenYe fen);
}

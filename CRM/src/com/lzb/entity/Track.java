package com.lzb.entity;

public class Track {

	private Integer Tid;
	private Integer Studentid;
	private Integer UserId;
	private String TrackStartData;
	private String TrackEndData;
	private String ReturnVisit;
	private String TrackingMode;
	private String Content;
	private String NextTrackingData;
	private String Operation;
	public Integer getTid() {
		return Tid;
	}
	public void setTid(Integer tid) {
		Tid = tid;
	}
	public Integer getStudentid() {
		return Studentid;
	}
	public void setStudentid(Integer studentid) {
		Studentid = studentid;
	}
	public Integer getUserId() {
		return UserId;
	}
	public void setUserId(Integer userId) {
		UserId = userId;
	}
	public String getTrackStartData() {
		return TrackStartData;
	}
	public void setTrackStartData(String trackStartData) {
		TrackStartData = trackStartData;
	}
	public String getTrackEndData() {
		return TrackEndData;
	}
	public void setTrackEndData(String trackEndData) {
		TrackEndData = trackEndData;
	}
	public String getReturnVisit() {
		return ReturnVisit;
	}
	public void setReturnVisit(String returnVisit) {
		ReturnVisit = returnVisit;
	}
	public String getTrackingMode() {
		return TrackingMode;
	}
	public void setTrackingMode(String trackingMode) {
		TrackingMode = trackingMode;
	}
	public String getContent() {
		return Content;
	}
	public void setContent(String content) {
		Content = content;
	}
	public String getNextTrackingData() {
		return NextTrackingData;
	}
	public void setNextTrackingData(String nextTrackingData) {
		NextTrackingData = nextTrackingData;
	}
	public String getOperation() {
		return Operation;
	}
	public void setOperation(String operation) {
		Operation = operation;
	}
	
}

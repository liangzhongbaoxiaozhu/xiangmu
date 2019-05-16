package com.lzb.entity;

import java.util.List;

public class FenYe<T> {
    private Integer page;
    private Integer pageSize;
    private Integer total;
    private List<T> rows;
    
    //用户条件
    private String LoginName;
    private Integer IsLoginData;
    private String cuanjiankaishi;
    private String cuanjianjieshu;
    private Integer paixu;
    
    
  //跟踪搜索条件
  	private String StudentName;
  	private String UserName;
  	private String TrackStartData;
  	private String TrackEndData;
  	private String ReturnVisit;
  	private String TrackingMode;
  	
  	//学生条件
  	 private String sname;
     private String Smtel;
     private String zixunshi;
     private String QQ;
     private String StartData;
     private String EndData;
     private String IsPay;
     private String IsEffective;
     private String IsReturnVisit;
     private Integer JiaoXueid;
  	
	public Integer getPage() {
		return page;
	}
	public void setPage(Integer page) {
		this.page = page;
	}
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	public Integer getTotal() {
		return total;
	}
	public void setTotal(Integer total) {
		this.total = total;
	}
	public List<T> getRows() {
		return rows;
	}
	public void setRows(List<T> rows) {
		this.rows = rows;
	}
	@Override
	public String toString() {
		return "FenYe [page=" + page + ", pageSize=" + pageSize + ", total="
				+ total + ", rows=" + rows + "]";
	}
	public String getLoginName() {
		return LoginName;
	}
	public void setLoginName(String loginName) {
		LoginName = loginName;
	}
	public Integer getIsLoginData() {
		return IsLoginData;
	}
	public void setIsLoginData(Integer isLoginData) {
		IsLoginData = isLoginData;
	}
	public String getCuanjiankaishi() {
		return cuanjiankaishi;
	}
	public void setCuanjiankaishi(String cuanjiankaishi) {
		this.cuanjiankaishi = cuanjiankaishi;
	}
	public String getCuanjianjieshu() {
		return cuanjianjieshu;
	}
	public void setCuanjianjieshu(String cuanjianjieshu) {
		this.cuanjianjieshu = cuanjianjieshu;
	}
	public Integer getPaixu() {
		return paixu;
	}
	public void setPaixu(Integer paixu) {
		this.paixu = paixu;
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
	public String getStudentName() {
		return StudentName;
	}
	public void setStudentName(String studentName) {
		StudentName = studentName;
	}
	public String getUserName() {
		return UserName;
	}
	public void setUserName(String userName) {
		UserName = userName;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getSmtel() {
		return Smtel;
	}
	public void setSmtel(String smtel) {
		Smtel = smtel;
	}
	public String getZixunshi() {
		return zixunshi;
	}
	public void setZixunshi(String zixunshi) {
		this.zixunshi = zixunshi;
	}
	public String getQQ() {
		return QQ;
	}
	public void setQQ(String qQ) {
		QQ = qQ;
	}
	public String getStartData() {
		return StartData;
	}
	public void setStartData(String startData) {
		StartData = startData;
	}
	public String getEndData() {
		return EndData;
	}
	public void setEndData(String endData) {
		EndData = endData;
	}
	public String getIsPay() {
		return IsPay;
	}
	public void setIsPay(String isPay) {
		IsPay = isPay;
	}
	public String getIsEffective() {
		return IsEffective;
	}
	public void setIsEffective(String isEffective) {
		IsEffective = isEffective;
	}
	public String getIsReturnVisit() {
		return IsReturnVisit;
	}
	public void setIsReturnVisit(String isReturnVisit) {
		IsReturnVisit = isReturnVisit;
	}
	public Integer getJiaoXueid() {
		return JiaoXueid;
	}
	public void setJiaoXueid(Integer jiaoXueid) {
		JiaoXueid = jiaoXueid;
	}
	
	
    
}

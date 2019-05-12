package com.lzb.entity;

import java.util.List;

public class FenYe<T> {
    private Integer page;
    private Integer pageSize;
    private Integer total;
    private List<T> rows;
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
    
}

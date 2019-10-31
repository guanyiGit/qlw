package com.soholy.dogmanager.entity.dogCard;

import java.io.Serializable;

public class PageInfo implements Serializable{
	//默认每页条数
	public static final Integer DefaultSize=10;
	
	//当前页数//从1开始
	private Integer pageNum;
	//每页显示记录条数
	private Integer pageSize;
	//总记录条数
	private Integer totalCount;
	//总页数
	private Integer pageCount;
	//记录开始处
	private Integer totalStart;
	//是否是第一页
	private boolean First;
	//是否是最后一页
	private boolean Last;
	
	public Integer getPageNum() {
		return pageNum;
	}
	public void setPageNum(Integer pageNum) {
		this.pageNum = pageNum;
	}
	
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	
	public Integer getTotalCount() {
		return totalCount;
	}
	
	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}
	public Integer getPageCount() {
		pageCount = (int)(getTotalCount()/ getPageSize());  
        return (((getTotalCount()==0)?1:getTotalCount())%getPageSize() == 0) ? pageCount  : pageCount + 1;  
	}
	
	public void setPageCount(Integer pageCount) {
		this.pageCount = pageCount;
	}
	public Integer getTotalStart() {
		return (pageNum - 1) * pageSize; 
	}
	public void setTotalStart(Integer totalStart) {
		this.totalStart = totalStart;
	}
	
	public boolean isFirst() {
		return (pageNum < 1) ? true : false;
	}
	public boolean isLast() {
		return (pageNum > getPageCount()) ? true : false;  
	}
	public void setLast(boolean last) {
		Last = last;
	}
	public void setFirst(boolean first) {
		First = first;
	}
	
	@Override
	public String toString() {
		return "PageInfo [pageNum=" + pageNum + ", pageSize=" + pageSize + ", totalCount=" + totalCount + ", pageCount="
				+ pageCount + ", totalStart=" + totalStart + ", First=" + First + ", Last=" + Last + "]";
	}
	
	
	
}

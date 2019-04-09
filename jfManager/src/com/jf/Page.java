package com.jf;

import java.util.List;

public class Page {
	//一页显示多少条
	private int pageSize=5;
	//当前页数，默认第一页
	private int pageNow=1;
	//记录条数，通过数据库统计
	private int recordCount;
	 //总共多少页
	private int pageCount;
	
	private int beginIndex;
	private int endIndex;
	//当前页的数据对象
	private List recordList;
	
	public Page(int pageNow, int recordCount, List recordList) {
		super();
		this.pageNow = pageNow;
		this.recordCount = recordCount;
		this.recordList = recordList;
		
		this.pageCount=(recordCount-1)/pageSize+1;
		if(pageCount<=10){
			beginIndex=1;
			endIndex=pageCount;
		}
		else{
			beginIndex=pageNow-4;
			endIndex=pageNow+5;
			if(beginIndex<1){
				beginIndex=1;
				endIndex=10;
			}
			if(endIndex>pageCount){
				beginIndex=pageCount-10+1;
				endIndex=pageCount;
			}
		}
	}
	
	
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getPageNow() {
		return pageNow;
	}
	public void setPageNow(int pageNow) {
		this.pageNow = pageNow;
	}
	public int getRecordCount() {
		return recordCount;
	}
	public void setRecordCount(int recordCount) {
		this.recordCount = recordCount;
	}
	public int getPageCount() {
		return pageCount;
	}
	public void setPageCount(int pageCount) {
		this.pageCount = pageCount;
	}
	public int getBeginIndex() {
		return beginIndex;
	}
	public void setBeginIndex(int beginIndex) {
		this.beginIndex = beginIndex;
	}
	public int getEndIndex() {
		return endIndex;
	}
	public void setEndIndex(int endIndex) {
		this.endIndex = endIndex;
	}
	public List getRecordList() {
		return recordList;
	}
	public void setRecordList(List recordList) {
		this.recordList = recordList;
	}
	
}

package cn.his.core.model;

public class Page {
	//页号
	private Integer pageNo = 1;
	//开始行
	private Integer startRow;
	//每页数
	private Integer pageSize = 10;
	
	public Integer getStartRow() {
		return startRow;
	}
	public void setStartRow(Integer startRow) {
		this.startRow = startRow;
	}
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		//计算一次开始行
		this.startRow = (pageNo - 1) * pageSize;
		this.pageSize = pageSize;
	}
	public Integer getPageNo() {
		return pageNo;
	}
	public void setPageNo(Integer pageNo) {
		//计算一次开始行
		this.startRow = (pageNo - 1) * pageSize;
		this.pageNo = pageNo;
	}
}

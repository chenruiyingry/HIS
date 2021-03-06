package cn.his.common.page;

import java.util.ArrayList;
import java.util.List;

public class Pagination extends SimplePage {

	public Pagination() {
	}
	
	/**
	 * 构造器
	 * @param pageNo 页码
	 * @param pageSize 每页几条数据
	 * @param totalCount 总共几条数据
	 */
	public Pagination(int pageNo, int pageSize, int totalCount) {
		super(pageNo, pageSize, totalCount);
	}
	
	/**
	 * 构造器
	 * @param pageNo 页码
	 * @param pageSize 每页几条数据
	 * @param totalCount 总共几条数据
	 * @param list 分页内容
	 */
	public Pagination(int pageNo, int pageSize, int totalCount, List<?> list) {
		super(pageNo, pageSize, totalCount);
		this.list = list;
	}
	
	/**
	 * 第一条数据位置
	 * @return
	 */
	public int getFirstResult() {
		return (pageNo - 1) * pageSize;
	}
	
	/**
	 * 当前页数据
	 */
	private List<?> list;
	
	/**
	 * 当前页的分页样式
	 */
	private List<String> pageView;

	/**
	 * 获得分页内容
	 * @return
	 */
	public List<?> getList() {
		return list;
	}

	/**
	 * 设置分页内容
	 * @param list
	 */
	public void setList(List<?> list) {
		this.list = list;
	}

	/**
	 * 获得分页样式
	 * @return
	 */
	public List<String> getPageView() {
		return pageView;
	}

	/**
	 * 设置分页样式
	 * @param pageView
	 */
	public void setPageView(List<String> pageView) {
		this.pageView = pageView;
	}
	
	/**
	 * 分页显示部分
	 * @param url
	 * @param params
	 */
	public void pageView(String url, String params) {
		pageView = new ArrayList<String>();
		
		if (this.pageNo != 1) {
			 pageView.add("<a class='firstpage' href=\"javascript:void(0);\" onclick=\"javascript:window.location.href='" + url + "?" + params + "&pageNo=1'\"><font class='firstpagefont' size=2>首页</font></a>");
			 pageView.add("<a class='previouspage' href=\"javascript:void(0);\" onclick=\"javascript:window.location.href='" + url + "?" + params + "&pageNo="+(this.pageNo-1)+"'\"><font class='previouspagefont' size=2>上一页</font></a>");
		} else {
			pageView.add("<font class='pagefont firstpage' size=2>首页</font>");
			pageView.add("<font class='pagefont previouspage' size=2>上一页</font>");
		}
		
		if (this.getTotalPage() <= 10) {
			 for (int i = 0; i < this.getTotalPage(); i++) {
				 if((i+1)==this.pageNo){
					 pageView.add("<strong class='active'>" + this.pageNo + "</strong>");
					 i = i + 1;
					 if(this.pageNo == this.getTotalPage()) break;
				 }
				 pageView.add("<a href=\"javascript:void(0);\" onclick=\"javascript:window.location.href='" + url + "?" + params + "&pageNo="+(i+1)+"'\">"+(i+1)+"</a>");
			 }
		} else if (this.getTotalPage() <= 20) {
			int l = 0;
			int r = 0;
			if (this.pageNo < 5) {	
				l = this.pageNo - 1;
				r = 10 - l - 1;
			} else if (this.getTotalPage()-this.pageNo<5) {
				r = this.getTotalPage() - this.pageNo;
				l = 10 - 1 - r;
			} else {
				l = 4;
				r = 5;
			}
			int tmp = this.pageNo - 1;
			for (int i = tmp; i < tmp + 10; i++) {
				if(i == this.pageNo){
					pageView.add("<strong>" + this.pageNo + "</strong>");
					i = i + 1;
					if(this.pageNo == this.getTotalPage()) break;
				}
				pageView.add("<a href=\"javascript:void(0);\" onclick=\"javascript:window.location.href='" + url + "?" + params + "&pageNo="+(i)+"'\">"+(i)+"</a>");
			}
		} else if (this.pageNo < 7) {
			for (int i = 0; i < 8; i++) {
				if(i + 1 == this.pageNo){
					pageView.add("<strong>" + this.pageNo + "</strong>");
					i = i + 1;
				}
				pageView.add("<a href=\"javascript:void(0);\" onclick=\"javascript:window.location.href='" + url + "?" + params + "&pageNo="+(i+1)+"'\">"+(i+1)+"</a>");
			}
			pageView.add("...");
			pageView.add("<a href=\"javascript:void(0);\" onclick=\"javascript:window.location.href='" + url + "?" + params + "&pageNo="+(this.getTotalPage()-1)+"'\">"+(this.getTotalPage()-1)+"</a>");
			pageView.add("<a href=\"javascript:void(0);\" onclick=\"javascript:window.location.href='" + url + "?" + params + "&pageNo="+(this.getTotalPage())+"'\">"+(this.getTotalPage())+"</a>");
		} else if (this.pageNo > this.getTotalPage() - 6) {
			pageView.add("<a href=\"javascript:void(0);\" onclick=\"javascript:window.location.href='" + url + "?" + params + "&pageNo="+(1)+"'\">"+(1)+"</a>");
			pageView.add("<a href=\"javascript:void(0);\" onclick=\"javascript:window.location.href='" + url + "?" + params + "&pageNo="+(2)+"'\">"+(2)+"</a>");
			pageView.add("...");
			for (int i = this.getTotalPage() - 8; i <this.getTotalPage() ; i++) {
				if(i+1 == this.pageNo){
					pageView.add("<strong>" + this.pageNo + "</strong>");
					i = i + 1;
					if(this.pageNo == this.getTotalPage()) break;
				}
				pageView.add("<a href=\"javascript:void(0);\" onclick=\"javascript:window.location.href='" + url + "?" + params + "&pageNo="+(i+1)+"'\">"+(i+1)+"</a>");
			}
		} else {
			pageView.add("<a href=\"javascript:void(0);\" onclick=\"javascript:window.location.href='" + url + "?" + params + "&pageNo="+(1)+"'\">"+(1)+"</a>");
			pageView.add("<a href=\"javascript:void(0);\" onclick=\"javascript:window.location.href='" + url + "?" + params + "&pageNo="+(2)+"'\">"+(2)+"</a>");
			pageView.add("...");
			pageView.add("<a href=\"javascript:void(0);\" onclick=\"javascript:window.location.href='" + url + "?" + params + "&pageNo="+(this.pageNo-2)+"'\">"+(this.pageNo-2)+"</a>");
			pageView.add("<a href=\"javascript:void(0);\" onclick=\"javascript:window.location.href='" + url + "?" + params + "&pageNo="+(this.pageNo-1)+"'\">"+(this.pageNo-1)+"</a>");
			pageView.add("<strong>" + this.pageNo + "</strong>");
			pageView.add("<a href=\"javascript:void(0);\" onclick=\"javascript:window.location.href='" + url + "?" + params + "&pageNo="+(this.pageNo+1)+"'\">"+(this.pageNo+1)+"</a>");
			pageView.add("<a href=\"javascript:void(0);\" onclick=\"javascript:window.location.href='" + url + "?" + params + "&pageNo="+(this.pageNo+2)+"'\">"+(this.pageNo+2)+"</a>");
			pageView.add("...");
			pageView.add("<a href=\"javascript:void(0);\" onclick=\"javascript:window.location.href='" + url + "?" + params + "&pageNo="+(this.getTotalPage()-1)+"'\">"+(this.getTotalPage()-1)+"</a>");
			pageView.add("<a href=\"javascript:void(0);\" onclick=\"javascript:window.location.href='" + url + "?" + params + "&pageNo="+(this.getTotalPage())+"'\">"+(this.getTotalPage())+"</a>");
		}
		if (this.pageNo != this.getTotalPage()) {
			pageView.add("<a class='nextpage' href=\"javascript:void(0);\" onclick=\"javascript:window.location.href='" + url + "?" + params + "&pageNo="+(this.pageNo+1)+"'\"><font class='nextpagefont' size=2>下一页</font></a>");
			pageView.add("<a class='lastpage' href=\"javascript:void(0);\" onclick=\"javascript:window.location.href='" + url + "?" + params + "&pageNo="+this.getTotalPage()+"'\"><font class='lastpagefont' size=2>尾页</font></a>");
		} else {
			pageView.add("<font class='pagefont nextpage' size=2>下一页</font>");
			pageView.add("<font class='pagefont lastpage' size=2>尾页</font>");
		}
		pageView.add("<lable>共" + getTotalPage() + "页 到第</lable><input type='text' class='nopage' id='PAGENO'  size='3' /><lable>页</lable> <input type='button' id='skip' class='define' value='确定' onclick=\"javascript:window.location.href = '" + url + "?" + params + "&pageNo=' + $('#PAGENO').val() \"/>");
	}	
}

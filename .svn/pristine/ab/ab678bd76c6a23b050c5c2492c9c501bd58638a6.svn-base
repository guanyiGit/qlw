/**
 * 
 */
package com.soholy.dogmanager.common.pojo;

import java.util.List;

/** 
* 
* 项目名称：InfoManagePlatform 
* 类名称：Page 
* 类描述： 
* 创建人：YL
* 创建时间：2018年6月4日 下午6:02:38 
* 修改人：Administrator 
* 修改时间：2018年6月4日 下午6:02:38 
* 修改备注： 
* 
*/
public class Page<T> {
	
    private int pageNumber;  //当前页码，前端页面传递
    private int totalRecord;  //总记录数，数据库查询得到
    private int pageSize;    //每页显示条数，前端页面传递
    private int totalPage;   //总页数，计算得到
    private int index;
    private List<T> lists;
    
    public List<T> getLists() {
		return lists;
	}

	public void setLists(List<T> lists) {
		this.lists = lists;
	}

	public Page() {
        super();
    }
    
    public Page(int pageNumber, int totalRecord, int pageSize) {
        super();
        this.pageNumber = pageNumber;
        this.totalRecord = totalRecord;
        this.pageSize = pageSize;
    }

 
    public int getPageNumber() {     //控制页码不能<1，也不能>totalPage
        if(pageNumber<1){
            pageNumber=1;
        }else if (pageNumber>getTotalPage()) {
            pageNumber=getTotalPage();
        }
        return pageNumber;
    }
    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }
    public int getTotalRecord() {
        return totalRecord;
    }
    public void setTotalRecord(int totalRecord) {
    	this.totalRecord = totalRecord;
    }
    public int getPageSize() {
        return pageSize;
    }
    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }
    public int getTotalPage() {
        return (int) Math.ceil((double)getTotalRecord()/getPageSize());
    }

	public int getIndex() {
        return (this.getPageNumber()-1)*this.getPageSize();     //分页查询，在数据访问层一定会调用getIndex方法获得索引值
    }                                                 //而在getIndex方法中调用了getPageNumber方法，保证了页码在正常范围内

	
	
	
	
    
}

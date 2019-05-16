package com.soholy.dogmanager.common.pojo;

import java.io.Serializable;

/** 
* 
* 项目名称：dogmanager-common 
* 类名称：TableSplitResult 
* 类描述： bootstarp返回数据包装类
* 创建人：YL
* 创建时间：2018年9月4日 下午2:35:41 
* 修改人：Administrator 
* 修改时间：2018年9月4日 下午2:35:41 
* 修改备注： 
* 
*/
public class TableSplitResult<T> implements Serializable{
	 
    private  Integer page;
    private Integer total;
    private T rows;
 
 
    public TableSplitResult() {
    }
 
    public TableSplitResult(Integer page, Integer total, T rows) {
        this.page = page;
        this.total = total;
        this.rows = rows;
    }
 
    public Integer getPage() {
        return page;
    }
 
    public void setPage(Integer page) {
        this.page = page;
    }
 
    public Integer getTotal() {
        return total;
    }
 
    public void setTotal(Integer total) {
        this.total = total;
    }
 
    public T getRows() {
        return rows;
    }
 
    public void setRows(T rows) {
        this.rows = rows;
    }
}


package com.soholy.dogmanager.common.pojo;

import java.io.Serializable;
import java.util.List;

public class PageInfo<T> implements Serializable {
		
	//当前页
    private int pageNum;
    
    //每页的数量
    private int pageSize;
	
    //当前页的数量
    private int size;
    
  //当前页面第一个元素在数据库中的行号
    private int startRow;
    
    //当前页面最后一个元素在数据库中的行号
    private int endRow;
    
  //总记录数
    private long total;
    //总页数
    private int pages;
    
  //结果集
    private List<T> list;
    
  //第一页
    private int firstPage;
    //前一页
    private int prePage;
    //下一页
    private int nextPage;
    //最后一页
    private int lastPage;
    
  //是否为第一页
    private boolean isFirstPage = false;
    //是否为最后一页
    private boolean isLastPage = false;
    //是否有前一页
    private boolean hasPreviousPage = false;
    //是否有下一页
    private boolean hasNextPage = false;
    
    
}

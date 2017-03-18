package com.jointstarc.ssm.first.common;

import java.util.List;

public class Pager {

	public static final Integer MAX_PAGE_SIZE = 200;// 每页最大记录数限制

	private Integer pageNumber = 1;// 当前页码
	private Integer rows = 5;// 每页记录数
	private Integer totalCount = 0;// 总记录数
	private Integer pageCount = 0;// 总页数
	private String order;// 顺序
	private List list;// 数据List
	private String property;// 查找字段
	private String keyword;// 查找关键字
	private String orderBy;// 排序字段
	private OrderType orderType = OrderType.desc;// 排序方式

	public Pager() {

	}

	public Pager(Integer pagerNumber, Integer rows, Integer totalCount) {
		this.pageNumber = pagerNumber;
		this.rows = rows;
		this.totalCount = totalCount;
	}

	// 排序方式
	public enum OrderType {
		asc, desc
	}

	public Integer getPageNumber() {
		return pageNumber;
	}

	public void setPageNumber(Integer pageNumber) {
		if (pageNumber < 1) {
			pageNumber = 1;
		}
		this.pageNumber = pageNumber;
	}

	public Integer getRows() {
		return rows;
	}

	public void setRows(Integer rows) {
		if (rows < 1) {
			rows = 1;
		} else if (rows > MAX_PAGE_SIZE) {
			rows = MAX_PAGE_SIZE;
		}
		this.rows = rows;
	}

	public Integer getTotalCount() {
		return totalCount;
	}

	public void setTotalCount(Integer totalCount) {
		this.totalCount = totalCount;
	}

	public String getProperty() {
		return property;
	}

	public void setProperty(String property) {
		this.property = property;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public String getOrderBy() {
		return orderBy;
	}

	public void setOrderBy(String orderBy) {
		this.orderBy = orderBy;
	}

	public OrderType getOrderType() {
		return orderType;
	}

	public void setOrderType(OrderType orderType) {
		this.orderType = orderType;
	}

	public Integer getPageCount() {
		pageCount = totalCount / rows;
		if (totalCount % rows > 0) {
			pageCount++;
		}
		return pageCount;
	}

	public void setPageCount(Integer pageCount) {
		this.pageCount = pageCount;
	}

	public List getList() {
		return list;
	}

	public void setList(List list) {
		this.list = list;
	}

	public String getOrder() {
		return order;
	}

	public void setOrder(String order) {
		this.order = order;
	}

}
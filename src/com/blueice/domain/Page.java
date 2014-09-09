package com.blueice.domain;

import java.io.Serializable;
import java.util.List;

public class Page implements Serializable{
	private int thisPage;
	private int rowperPage;
	private int countRow;
	private int countPage;
	private int firstPage;
	private int lastPage;
	private int prevPage;
	private int nextPage;
	private List<Cust> list;
	
	
	public List<Cust> getList() {
		return list;
	}
	public void setList(List<Cust> list) {
		this.list = list;
	}
	
	public int getThisPage() {
		return thisPage;
	}
	public void setThisPage(int thisPage) {
		this.thisPage = thisPage;
	}
	public int getRowperPage() {
		return rowperPage;
	}
	public void setRowperPage(int rowperPage) {
		this.rowperPage = rowperPage;
	}
	public int getCountRow() {
		return countRow;
	}
	public void setCountRow(int countRow) {
		this.countRow = countRow;
	}
	public int getCountPage() {
		return countPage;
	}
	public void setCountPage(int countPage) {
		this.countPage = countPage;
	}
	public int getFirstPage() {
		return firstPage;
	}
	public void setFirstPage(int firstPage) {
		this.firstPage = firstPage;
	}
	public int getLastPage() {
		return lastPage;
	}
	public void setLastPage(int lastPage) {
		this.lastPage = lastPage;
	}
	public int getPrevPage() {
		return prevPage;
	}
	public void setPrevPage(int prevPage) {
		this.prevPage = prevPage;
	}
	public int getNextPage() {
		return nextPage;
	}
	public void setNextPage(int nextPage) {
		this.nextPage = nextPage;
	}
	
	
	
}

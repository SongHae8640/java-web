package com.bit.model;

import java.sql.Date;

public class Guest02Dto {
	private int num;
	private String sub;
	private int unum;
	private Date nalja;
	private int pay;
	
	
	public int getNum() {
		return num;
	}
	public String getSub() {
		return sub;
	}
	public int getUnum() {
		return unum;
	}
	public Date getNalja() {
		return nalja;
	}
	public int getPay() {
		return pay;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public void setSub(String sub) {
		this.sub = sub;
	}
	public void setUnum(int unum) {
		this.unum = unum;
	}
	public void setNalja(Date nalja) {
		this.nalja = nalja;
	}
	public void setPay(int pay) {
		this.pay = pay;
	}
}

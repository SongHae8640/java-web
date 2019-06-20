package com.bit.model;

import java.sql.Date;

public class Guest02Dto{
	private int num;
	private String sub;
	private int unum;
	private Date nalja;
	private int pay;
	private String name;
	
	
	
	public Guest02Dto() {

	}
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
	public String getName() {
		return name;
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
	public void setName(String name) {
		this.name = name;
	}
	
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + num;
		result = prime * result + pay;
		result = prime * result + ((sub == null) ? 0 : sub.hashCode());
		result = prime * result + unum;
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Guest02Dto other = (Guest02Dto) obj;
		if (num != other.num)
			return false;
		if (pay != other.pay)
			return false;
		if (sub == null) {
			if (other.sub != null)
				return false;
		} else if (!sub.equals(other.sub))
			return false;
		if (unum != other.unum)
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "Guest02Dto [num=" + num + ", sub=" + sub + ", unum=" + unum
				+ ", nalja=" + nalja + ", pay=" + pay + ", name=" + name + "]";
	}
	
	
	
	
	
}

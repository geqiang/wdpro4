package com.qfedu.entity;

public class Cartitem {
	
	private int caid;
	private String p8;
	private String pname;
	private Double price;
	private String name;
	private String img1;
	private int	count;
	private int pid;
	private String  b3;
	private String  b4;
	@Override
	public String toString() {
		return "Cartitem [caid=" + caid + ", p8=" + p8 + ", pname=" + pname + ", price=" + price + ", name=" + name
				+ ", img1=" + img1 + ", count=" + count + ", pid=" + pid + ", b3=" + b3 + ", b4=" + b4 + "]";
	}
	public int getCaid() {
		return caid;
	}
	public void setCaid(int caid) {
		this.caid = caid;
	}
	public String getP8() {
		return p8;
	}
	public void setP8(String p8) {
		this.p8 = p8;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getImg1() {
		return img1;
	}
	public void setImg1(String img1) {
		this.img1 = img1;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getB3() {
		return b3;
	}
	public void setB3(String b3) {
		this.b3 = b3;
	}
	public String getB4() {
		return b4;
	}
	public void setB4(String b4) {
		this.b4 = b4;
	}
	
	
	
	
	
	
}

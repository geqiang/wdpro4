package com.qfedu.entity;

public class OrderCartitem {

	private int oid;
	private String oname;
	private String otele;
	private String addr;
	private int pid;
	private String time;
	private String status;
	private String name;
	private String poset;
	private Double prices;
	private String o1;
	private String o2;
	private int o3;
	private String o4;
	@Override
	public String toString() {
		return "OrderCartitem [oid=" + oid + ", oname=" + oname + ", otele=" + otele + ", addr=" + addr + ", pid=" + pid
				+ ", time=" + time + ", status=" + status + ", name=" + name + ", poset=" + poset + ", prices=" + prices
				+ ", o1=" + o1 + ", o2=" + o2 + ", o3=" + o3 + ", o4=" + o4 + "]";
	}
	public int getOid() {
		return oid;
	}
	public void setOid(int oid) {
		this.oid = oid;
	}
	public String getOname() {
		return oname;
	}
	public void setOname(String oname) {
		this.oname = oname;
	}
	public String getOtele() {
		return otele;
	}
	public void setOtele(String otele) {
		this.otele = otele;
	}
	public String getAddr() {
		return addr;
	}
	public void setAddr(String addr) {
		this.addr = addr;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public String getTime() {
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPoset() {
		return poset;
	}
	public void setPoset(String poset) {
		this.poset = poset;
	}
	public Double getPrices() {
		return prices;
	}
	public void setPrices(Double prices) {
		this.prices = prices;
	}
	public String getO1() {
		return o1;
	}
	public void setO1(String o1) {
		this.o1 = o1;
	}
	public String getO2() {
		return o2;
	}
	public void setO2(String o2) {
		this.o2 = o2;
	}
	public int getO3() {
		return o3;
	}
	public void setO3(int o3) {
		this.o3 = o3;
	}
	public String getO4() {
		return o4;
	}
	public void setO4(String o4) {
		this.o4 = o4;
	}
	
	
	
}

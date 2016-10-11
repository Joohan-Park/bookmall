package com.bit2016.bookmall.vo;

public class OrderVo {
	private Long no;
	private Long price;
	private String address;
	private Long memberNo;
	public Long getNo() {
		return no;
	}
	public void setNo(Long no) {
		this.no = no;
	}
	public Long getPrice() {
		return price;
	}
	public void setPrice(Long price) {
		this.price = price;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Long getMemberNo() {
		return memberNo;
	}
	public void setMemberNo(Long memberNo) {
		this.memberNo = memberNo;
	}
	@Override
	public String toString() {
		return "OrderVo [no=" + no + ", price=" + price + ", address=" + address + ", memberNo=" + memberNo + "]";
	}
	
}

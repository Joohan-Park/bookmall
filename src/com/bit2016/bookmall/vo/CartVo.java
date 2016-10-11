package com.bit2016.bookmall.vo;

public class CartVo {
	private Long bookNo;
	private Long memberNo;
	private Long count;
	public Long getBookNo() {
		return bookNo;
	}
	public void setBookNo(Long bookNo) {
		this.bookNo = bookNo;
	}
	public Long getMemberNo() {
		return memberNo;
	}
	public void setMemberNo(Long memberNo) {
		this.memberNo = memberNo;
	}
	public Long getCount() {
		return count;
	}
	public void setCount(Long count) {
		this.count = count;
	}
	@Override
	public String toString() {
		return "CartVo [bookNo=" + bookNo + ", memberNo=" + memberNo + ", count=" + count + "]";
	}
	
}

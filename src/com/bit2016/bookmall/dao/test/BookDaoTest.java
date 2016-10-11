package com.bit2016.bookmall.dao.test;

import java.util.List;

import com.bit2016.bookmall.dao.BookDao;
import com.bit2016.bookmall.vo.BookVo;

public class BookDaoTest {
	public static void main(String[] args) {
		//insert test
		//insertTest();

		//getlist test
		getListTest();
	}
	public static void insertTest(){
		BookDao dao = new BookDao();
	
		BookVo vo1 = new BookVo();
		vo1.setTitle("이것이 자바다");
		vo1.setPrice(30000L);
		vo1.setCategoryNumber(3L);
		dao.insert(vo1);
		
		BookVo vo2 = new BookVo();
		vo2.setTitle("난중일기");
		vo2.setPrice(20000L);
		vo2.setCategoryNumber(2L);
		dao.insert(vo2);
		
		BookVo vo3 = new BookVo();
		vo3.setTitle("자바의 정석");
		vo3.setPrice(30000L);
		vo3.setCategoryNumber(3L);
		dao.insert(vo3);
		
		BookVo vo4 = new BookVo();
		vo4.setTitle("개미");
		vo4.setPrice(40000L);
		vo4.setCategoryNumber(1L);
		dao.insert(vo4);
		
		BookVo vo5 = new BookVo();
		vo5.setTitle("경제학");
		vo5.setPrice(35000L);
		vo5.setCategoryNumber(5L);
		dao.insert(vo5);
		
		BookVo vo6 = new BookVo();
		vo6.setTitle("예술학");
		vo6.setPrice(31000L);
		vo6.setCategoryNumber(6L);
		dao.insert(vo6);
		
		BookVo vo7 = new BookVo();
		vo7.setTitle("인문학");
		vo7.setPrice(30000L);
		vo7.setCategoryNumber(4L);
		dao.insert(vo7);
		
		BookVo vo8 = new BookVo();
		vo8.setTitle("예술의 이해");
		vo8.setPrice(30000L);
		vo8.setCategoryNumber(6L);
		dao.insert(vo8);
	
	}
	public static void getListTest(){
		BookDao dao = new BookDao();
		List<BookVo> list = dao.getList();
		
		for(BookVo vo : list){
			//System.out.println(vo.getNo()+":"+vo.getName());
			System.out.println(vo);
		}
	}
}

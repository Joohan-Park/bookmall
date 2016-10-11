package com.bit2016.bookmall.dao.test;

import java.util.List;

import com.bit2016.bookmall.dao.OrderBookDao;
import com.bit2016.bookmall.vo.OrderBookVo;

public class OrderBookDaoTest {
	public static void main(String[] args) {
		//insert test
		insertTest();

		//getlist test
		getListTest();
	}
	public static void insertTest(){
		OrderBookDao dao = new OrderBookDao();
	
		OrderBookVo vo1 = new OrderBookVo();
		vo1.setBookNo(1L);
		vo1.setOrderNo(1L);
		vo1.setCount(1L);
		dao.insert(vo1);
		
		
	
	}
	public static void getListTest(){
		OrderBookDao dao = new OrderBookDao();
		List<OrderBookVo> list = dao.getList();
		
		for(OrderBookVo vo : list){
			//System.out.println(vo.getNo()+":"+vo.getName());
			System.out.println(vo);
		}
	}
}

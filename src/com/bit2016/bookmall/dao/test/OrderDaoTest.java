package com.bit2016.bookmall.dao.test;

import java.util.List;

import com.bit2016.bookmall.dao.OrderDao;
import com.bit2016.bookmall.vo.OrderVo;

public class OrderDaoTest {
	public static void main(String[] args) {
		//insert test
		insertTest();

		//getlist test
		getListTest();
	}
	public static void insertTest(){
		OrderDao dao = new OrderDao();
	
		OrderVo vo1 = new OrderVo();
		vo1.setPrice(35000L);
		vo1.setAddress("관악구 인헌3길 54");
		vo1.setMemberNo(1L);
		dao.insert(vo1);
	}
	public static void getListTest(){
		OrderDao dao = new OrderDao();
		List<OrderVo> list = dao.getList();
		
		for(OrderVo vo : list){
			//System.out.println(vo.getNo()+":"+vo.getName());
			System.out.println(vo);
		}
	}
}

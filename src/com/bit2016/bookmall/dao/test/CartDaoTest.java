package com.bit2016.bookmall.dao.test;

import java.util.List;

import com.bit2016.bookmall.dao.CartDao;
import com.bit2016.bookmall.vo.CartVo;

public class CartDaoTest {
	public static void main(String[] args) {
		//insert test
		insertTest();

		//getlist test
		getListTest();
	}
	public static void insertTest(){
		CartDao dao = new CartDao();
	
		CartVo vo1 = new CartVo();
		vo1.setBookNo(1L);
		vo1.setMemberNo(1L);
		vo1.setCount(3L);
		dao.insert(vo1);
	}
	public static void getListTest(){
		CartDao dao = new CartDao();
		List<CartVo> list = dao.getList();
		
		for(CartVo vo : list){
			//System.out.println(vo.getNo()+":"+vo.getName());
			System.out.println(vo);
		}
	}
}

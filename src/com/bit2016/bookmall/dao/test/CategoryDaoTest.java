package com.bit2016.bookmall.dao.test;

import java.util.List;

import com.bit2016.bookmall.dao.CategoryDao;
import com.bit2016.bookmall.vo.CategoryVo;

public class CategoryDaoTest {

	public static void main(String[] args) {
		//insert test
		//insertTest();

		//getlist test
		getListTest();
	}
	public static void insertTest(){
		CategoryDao dao = new CategoryDao();
		
		CategoryVo vol = new CategoryVo();
		vol.setName("소설");
		dao.insert(vol);
		
		CategoryVo vo2 = new CategoryVo();
		vo2.setName("수필");
		dao.insert(vo2);
		
		CategoryVo vo3 = new CategoryVo();
		vo3.setName("컴퓨터/IT");
		dao.insert(vo3);
		
		CategoryVo vo4 = new CategoryVo();
		
		vo4.setName("인문");
		dao.insert(vo4);
		
		CategoryVo vo5 = new CategoryVo();
		vo5.setName("경제");
		dao.insert(vo5);
		
		CategoryVo vo6 = new CategoryVo();
		vo6.setName("예술");
		dao.insert(vo6);
	}
	public static void getListTest(){
		CategoryDao dao = new CategoryDao();
		List<CategoryVo> list = dao.getList();
		
		for(CategoryVo vo : list){
			//System.out.println(vo.getNo()+":"+vo.getName());
			System.out.println(vo);
		}
	}

}

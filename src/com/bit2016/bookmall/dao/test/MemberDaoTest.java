package com.bit2016.bookmall.dao.test;

import java.util.List;

import com.bit2016.bookmall.dao.MemberDao;
import com.bit2016.bookmall.vo.MemberVo;

public class MemberDaoTest {
	public static void main(String[] args) {
		//insert test
		//insertTest();

		//getlist test
		getListTest();
	}
	public static void insertTest(){
		MemberDao dao = new MemberDao();
	
		MemberVo vo1 = new MemberVo();
		vo1.setName("박주한");
		vo1.setPhone("010-3551-4188");
		vo1.setEmail("wngksqkr91@naver.com");
		vo1.setPassword("qkrwngks");
		dao.insert(vo1);
	}
	public static void getListTest(){
		MemberDao dao = new MemberDao();
		List<MemberVo> list = dao.getList();
		
		for(MemberVo vo : list){
			//System.out.println(vo.getNo()+":"+vo.getName());
			System.out.println(vo);
		}
	}
}

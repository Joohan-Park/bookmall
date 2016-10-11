package com.bit2016.bookmall.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.bit2016.bookmall.vo.CartVo;

public class CartDao {
	private Connection getConnection() throws SQLException{
		Connection conn = null;
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@localhost:1521:xe";
			conn = DriverManager.getConnection(url,"bitdb","bitdb");
		} catch(ClassNotFoundException e){
			System.out.println("드라이버 로딩 실패"+e);
		} 
		return conn;
	
	}
	
	public boolean insert(CartVo vo){
		Connection conn = null;
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			//1.connection 가져오기
			conn = getConnection();

			//2. Statement 준비
			String sql = "insert into cart values(?,?,?)";
			pstmt = conn.prepareStatement(sql);

			//3. 값 바인딩
			pstmt.setLong(1, vo.getBookNo());
			pstmt.setLong(2, vo.getMemberNo());
			pstmt.setLong(3, vo.getCount());

			//4.SQL실행
			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			System.out.println("error: " + e);
		} finally {
			try {
				// 3. 자원정리
				if (pstmt != null) {
					pstmt.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return result == 1;
	}

	public List<CartVo> getList() {
		List<CartVo> list = new ArrayList<CartVo>();
		// 1. Connection
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try{
			conn = getConnection();
			stmt = conn.createStatement();
			
			String sql = "select book_number,member_num,count from cart order by book_number asc";
			rs = stmt.executeQuery(sql);
			while(rs.next()){
				Long bookNo = rs.getLong(1);
				Long memberNo = rs.getLong(2);
				Long count = rs.getLong(3);
				
				
				CartVo vo = new CartVo();
				vo.setBookNo(bookNo);
				vo.setMemberNo(memberNo);
				vo.setCount(count);
				
				list.add(vo);
			}
			
		}catch(SQLException e){
			System.out.println("error"+e);
		}finally{
			try{
				if(rs!=null){
					rs.close();
				}
				if(stmt!=null){
					stmt.close();
				}
				if(conn!=null){
					conn.close();
				}
			}catch(SQLException e){
				System.out.println("error"+e);
			}
		}
		
		return list;
	}
}

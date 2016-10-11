package com.bit2016.bookmall.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.bit2016.bookmall.vo.OrderBookVo;

public class OrderBookDao {
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
	
	public boolean insert(OrderBookVo vo){
		Connection conn = null;
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			//1.connection 가져오기
			conn = getConnection();

			//2. Statement 준비
			String sql = "insert into order_book values(?,?,?)";
			pstmt = conn.prepareStatement(sql);

			//3. 값 바인딩
			pstmt.setLong(1, vo.getOrderNo());
			pstmt.setLong(2, vo.getBookNo());
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

	public List<OrderBookVo> getList() {
		List<OrderBookVo> list = new ArrayList<OrderBookVo>();
		// 1. Connection
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try{
			conn = getConnection();
			stmt = conn.createStatement();
			
			String sql = "select order_number, book_number, count from order_book order by order_number asc";
			rs = stmt.executeQuery(sql);
			while(rs.next()){
				Long orderNo = rs.getLong(1);
				Long bookNo = rs.getLong(2);
				Long count = rs.getLong(3);
				
				OrderBookVo vo = new OrderBookVo();
				vo.setOrderNo(orderNo);
				vo.setBookNo(bookNo);
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

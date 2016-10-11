package com.bit2016.bookmall.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.bit2016.bookmall.vo.OrderVo;

public class OrderDao {
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
	
	public boolean insert(OrderVo vo){
		Connection conn = null;
		PreparedStatement pstmt = null;
		int result = 0;
		try {
			//1.connection 가져오기
			conn = getConnection();

			//2. Statement 준비
			String sql = "insert into orders values(orders_seq.nextval,?,?,?)";
			pstmt = conn.prepareStatement(sql);

			//3. 값 바인딩
			pstmt.setLong(1, vo.getPrice());
			pstmt.setString(2, vo.getAddress());
			pstmt.setLong(3, vo.getMemberNo());

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

	public List<OrderVo> getList() {
		List<OrderVo> list = new ArrayList<OrderVo>();
		// 1. Connection
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try{
			conn = getConnection();
			stmt = conn.createStatement();
			
			String sql = "select no,price,address,member_no from orders order by no asc";
			rs = stmt.executeQuery(sql);
			while(rs.next()){
				Long no = rs.getLong(1);
				Long price = rs.getLong(2);
				String address = rs.getString(3);
				Long memberNo = rs.getLong(4);
				
				OrderVo vo = new OrderVo();
				vo.setNo(no);	
				vo.setPrice(price);
				vo.setAddress(address);
				vo.setMemberNo(memberNo);
				
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

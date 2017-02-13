package com.bit2017.mysite.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.bit2017.mysite.vo.UserVo;

public class UserDao {
	
	private Connection getConnection() throws SQLException {
		Connection conn = null;
		
		//1. JDBC Driver Loading ( JDBC Class Loading )
		try {
			Class.forName( "oracle.jdbc.driver.OracleDriver" );
		} catch (ClassNotFoundException e) {
			System.out.println( "Driver 로딩 실패 :" + e );
		}
		
		//2. Connection 얻어오기( Connect to DB )
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		conn = DriverManager.getConnection(url, "webdb", "webdb");
		
		return conn;
	}
	
	public boolean insert( UserVo userVo ) {
		boolean result = false;
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = getConnection();
			
			String sql = "insert into users values ( seq_users.nextval, ?, ?, ?, ?)";
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString( 1, userVo.getName() );
			pstmt.setString( 2, userVo.getEmail() );
			pstmt.setString( 3, userVo.getPassword() );
			pstmt.setString( 4, userVo.getGender() );
			
			int count = pstmt.executeUpdate();
			
			result = count == 1; 
		} catch( SQLException e ) {
			System.out.println( "error:" + e );
		} finally {
			try {
				if( pstmt != null ) {
					pstmt.close();
				}
				if( conn != null ) {
					conn.close();
				}
			} catch( SQLException e ) {
				System.out.println( "error:" + e );
			}
		}
		
		return result;
	}
}

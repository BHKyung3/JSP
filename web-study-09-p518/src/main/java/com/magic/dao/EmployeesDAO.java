package com.magic.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.magic.dto.EmployeesVO;

public class EmployeesDAO {

	
	private static EmployeesDAO instance = new EmployeesDAO();
	
	private EmployeesDAO() {}
	
	public static EmployeesDAO getInstance() {
		return instance;
	}
	
	//1. DB 연결
	public Connection getConnection() throws Exception{	
			
		String url = "jdbc:oracle:thin:@localhost:49161:xe";
		String uid = "system";
		String pass = "oracle";
			
		Class.forName("oracle.jdbc.driver.OracleDriver");
			
		//2. DB연결	    
			
		return DriverManager.getConnection(url,uid,pass);
	}

	public int userCheck(String id, String pass, String lev) {
		int result = -1;
		
		String sql = "select pass, lev from EMPLOYEES where id = ?";
		//"member"라는 테이블에서 "userid"가 어떤 값과 일치하는 행의 "pwd" 값을 가져와라"
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;  //sql구문이 select일 때만 기입!
		
		try {
			//1. db연결
			conn = getConnection();
			//2. sql구문 전송
			pstmt = conn.prepareStatement(sql);
			//3. sql 맵핑
			pstmt.setString(1,  id);
			//4. sql 실행
			rs = pstmt.executeQuery(); //sql구문이 select일 때만
			
			if(rs.next()) {//userid 존재(일치)
				
				if(rs.getString("pass") !=null && rs.getString("pass").equals(pass)){
					
					if(rs.getString("lev") !=null && rs.getString("lev").equals(lev)) {
						
						result = 1; 
						
					}else {
						result = -2; 
						
					}
					
				}else{
					
					result = 0;
					
				}
				
			}else {//userid 부존재(불일치)

			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if (rs != null) rs.close();
				if (pstmt != null) pstmt.close();
				if (conn != null) conn.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return result;
	}

	public EmployeesVO getEmployees(String id) {
		EmployeesVO eVo = null;
		String sql = "select * from EMPLOYEES where id = ?";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {//반복해서 조회할 땐 while, 한 번만 조회해도 된다면 if
				String userid = rs.getString("id");
				String pass = rs.getString("pass");
				String name = rs.getString("name");
				String lev = rs.getString("lev");
				String enter = rs.getString("enter");
				String gender = rs.getString("gender");
				String phone = rs.getString("phone");

				eVo = new EmployeesVO();
				eVo.setId(userid);
				eVo.setPass(pass);
				eVo.setName(name);
				eVo.setLev(lev);
				eVo.setEnter(enter);
				eVo.setGender(gender);
				eVo.setPhone(phone);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(rs !=null) rs.close();
				if(pstmt !=null) pstmt.close();
				if(conn !=null) conn.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		return eVo;
	}

	public void myPage(EmployeesVO eVo) {
		

		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String sql = "update employees set pass=?, name=?, lev=?, gender=?, phone=? where id=?";
		
		try {
			//1.DB연결
			conn = getConnection();
			//2.sql구문 전송
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, eVo.getPass());
			pstmt.setString(2, eVo.getName());
			pstmt.setString(3, eVo.getLev());
			pstmt.setString(4, eVo.getGender());
			pstmt.setString(5, eVo.getPhone());
			pstmt.setString(6, eVo.getId());
			/*3.sql구문 실행. 	executeUpdate는 insert, update, delete시 사용. commit은 자동으로 commit됨.*/
			pstmt.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
	}

	public int insertEmployees(EmployeesVO eVo) {
		int result = -1;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String sql = "insert into employees (id, pass, name, lev, gender, phone) values (?,?,?,?,?,?)";
		
		try {
			//1.DB연결
			conn = getConnection();
			//2.sql구문 전송
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, eVo.getId());
			pstmt.setString(2, eVo.getPass());
			pstmt.setString(3, eVo.getName());
			pstmt.setString(4, eVo.getLev());
			pstmt.setString(5, eVo.getGender());
			pstmt.setString(6, eVo.getPhone());
			/*3.sql구문 실행. 	executeUpdate는 insert, update, delete시 사용.
			result=0 : 저장 실패. result=1 : 저장 성공		commit은 자동으로 commit됨.*/
			result = pstmt.executeUpdate();
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		return result;
	}
}

/*
  	데이터베이스 테이블과 연동해서 작업하는 테이블에서 정보를 조회, 추가, 수정 삭제하는 클래스
  	
  	데이터베이스 데이터를 VO 객체로 얻어오거나 VO 객체에 저장된 값을 데이터베이스에 추가하는 역할
  	해당 작업을 위해 매번 객체 생성보다는 싱글톤 패턴으로 클래스 설계
  	
  	싱글톤 패턴 : 인스턴스가 오로지 단 하나만 존재할 수 있도록 클래스를 설계하는 것
  	 ㄴ 객체를 메모리에 단 한 번만 올려 놓고 시스템 전반에 걸쳐 특정한 자원을 공유할 때 사용
  	 ㄴ 객체를 여러 번 생성할 경우 전체적인 시스템의 성능이 저하되기 때문에 객체 생성을 여러 번 하는 것을 강제로 막기 위히한 싱글톤 형태로 만듬
 */

package com.magic.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.magic.dto.EmployeesVO;


public class EmployeesDAO {
	
	private static EmployeesDAO instance = new EmployeesDAO();
	
	private EmployeesDAO () {}
	
	public static EmployeesDAO getInstance() { // 싱글톤 패턴
		return instance;
	}
	
	// DBCP로 커넥션 객체를 얻어오는 메소드 추가, 오라클 DB 연결하는 메소드
	public Connection getConnection() throws Exception {
		
		String url = "jdbc:oracle:thin:@localhost:49161:xe"; 
		String uid = "system";
		String pass = "oracle"; 
		
		Class.forName("oracle.jdbc.driver.OracleDriver"); // 요거 미기재 시 동작하지 않음
		return DriverManager.getConnection(url, uid, pass); // DriverManager.getConnection()으로 실제 연결
		
	}
	// 로그인
	public int userCheck(String userid, String pass) {
		
	      int result = -1;
	      
	      String sql = "select pass, lev from employees where id = ?";

	      Connection conn = null;
	      PreparedStatement pstmt = null;
	      ResultSet rs = null;  //sql구문이 select일 때만 기입!
	      
	      try {
	         //1. db연결
	         conn = getConnection();
	         //2. sql구문 전송
	         pstmt = conn.prepareStatement(sql);
	         //3. sql 맵핑
	         pstmt.setString(1,  userid);
	         //4. sql 실행
	         rs = pstmt.executeQuery(); //sql구문이 select일 때만
	         
	         if(rs.next()) {//userid 존재(일치)
	            if(rs.getString("pass") !=null && rs.getString("pass").equals(pass)) {
	          
	            		
	               result = 1;  //userid, pwd 일치
	            }else {
	               result = 0;  //userid 일치, pwd 불일치
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
	   } // 로그인 끝
	// 
	public EmployeesVO getEmployees(String id) {
		EmployeesVO eVO = null;
		
		String sql = "select * from employees where id = ?";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			if(rs.next()) { // 값 꺼내기
				String userid = rs.getString("id");
				String pass = rs.getString("pass");
				String name = rs.getString("name");
				String lev = rs.getString("lev");
				String enter = rs.getString("enter");
				String gender = rs.getString("gender");
				String phone = rs.getString("phone");
				
				
				eVO = new EmployeesVO(); // VO에 담기(저장)
				eVO.setId(userid);
				eVO.setPass(pass);
				eVO.setName(name);
				eVO.setLev(lev);
				eVO.setEnter(enter);
				eVO.setGender(gender);
				eVO.setPhone(phone);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		} finally {
			
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
		} catch(Exception e) {
			e.printStackTrace();
			}
		}
		return eVO;
	} // DB저장 시작
	
	public int insertEmployees(EmployeesVO eVO) {
		
		int result = -1;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String sql = "insert into employees values(?, ?, ?, ?, ?, ?, ?)";
		
		try {
			conn = getConnection();
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, eVO.getId());
			pstmt.setString(2, eVO.getPass());
			pstmt.setString(3, eVO.getName());
			pstmt.setString(4, eVO.getLev());
			pstmt.setString(5, eVO.getEnter());
			pstmt.setString(6, eVO.getGender());
			pstmt.setString(7, eVO.getPhone());
			
			/* 3. SQL 구문 실행
			executeUpdate => insert, update, delete시 사용
			result : 0 -> 저장 실패
			result : 1 -> 저장 성공
			commit는 auto commit;
		 */
			result = pstmt.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		return result;
	} // DB저장 끝
	
	// 회원정보 수정
	public void updateEmployees(EmployeesVO eVO) {

		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String sql = "update employees set pass=?, name=?, lev=?, gender=?, phone=? where id=?";
		
		try {
			conn = getConnection();
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, eVO.getPass());
			pstmt.setString(2, eVO.getName());
			pstmt.setString(3, eVO.getLev());
			pstmt.setString(4, eVO.getGender());
			pstmt.setString(5, eVO.getPhone());
			pstmt.setString(6, eVO.getId());
			
			/* 3. SQL 구문 실행
			executeUpdate => insert, update, delete시 사용
			result : 0 -> 저장 실패
			result : 1 -> 저장 성공
			commit는 auto commit;
		 */
			
			pstmt.executeUpdate();
			
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch(Exception e) {
				e.printStackTrace();
			} // end catch
		}
	}
}


// MemberDAO 클래스는 자바 백엔드에서 DB 연결 + 회원 관련 로직 처리를 담당하는 핵심 DAO 클래스 
// DAO는 Data Access Object의 약자고, 말 그대로 데이터에 접근하는 로직만 모아둔 클래스

package com.saeyan.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.saeyan.dto.MemberVO;

public class MemberDAO {
	
	private static MemberDAO instance = new MemberDAO();
	
	private MemberDAO () {}
	
	public static MemberDAO getInstance() { // 싱글톤 패턴 : 인스턴스가 오르지 단 하나만 존재할 수 있도록 클래스를 만드는것(DB 작업 중복 방지 + 메모리 절약이 가능)
		return instance;
	}
	// 오라클 DB 연결하는 역할 메소드
	public Connection getConnection() throws Exception {
		
		String url = "jdbc:oracle:thin:@localhost:49161:xe"; 
		String uid = "system";
		String pass = "oracle"; 
		
		Class.forName("oracle.jdbc.driver.OracleDriver"); // 요거 미기재 시 동작하지 않음
		return DriverManager.getConnection(url, uid, pass); // DriverManager.getConnection()으로 실제 연결
		
	}

	// userid, pwd 전달 받아서, DB랑 연동해서 데이터가 있는지 조회, 반환타입이 정수(숫자)니까 int로 해줘야함 
	public int userCheck(String userid, String pwd) { // 로그인 시 아이디/비밀번호 체크

		/* 로그인 기능 만들 때 사용
		 1이면 userid, pwd 일치(로그인 성공)
		 0이면 userid 일치, pwd 불일치(아이디는 있음, 비밀번호 틀림)
		 -1이면 userid 불일치(아이디 없음)
		 * */
		
		int result = -1;
		
		// "member"라는 테이블에서 "userid"가 어떤 값과 일치하는 행의 "pwd" 값을 가져와라" 의미
		String sql = "select pwd from member where userid = ?";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null; // sql구문이 select일때만 기입!
		
		try {
			// 1. DB 연결
			conn = getConnection();
			// 2. SQL구문 전송
			pstmt =  conn.prepareStatement(sql);
			// 3. SQL 맵핑
			pstmt.setString(1, userid);
			// 4. SQL 구문 실행
			rs = pstmt.executeQuery(); // SQL구문이 select일때만
			
			if(rs.next()) {
				// 회원 ID 존재할 때
				if(rs.getString("pwd") != null && rs.getString("pwd").equals(pwd)) {
					result = 1; // userid, pwd 일치
				} else {
					result = 0; // pwd만 불일치
				}
			} else {
				// 이런 회원ID는 없다!
				result = -1;
			}
			
		} catch(Exception e) {
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
		return result;
	}

	// userid로 회원 정보 전체 가져오기
	public MemberVO getMember(String userid) { // userid를 이용해서 DB에서 해당 회원의 정보를 가져오고
		
		MemberVO mVO = null; // 가져온 정보를 MemberVO 객체에 담아서 리턴하는 메서드, 아직 회원 정복 ㅏ없으니 NULL 초기화
		
		String sql = "select * from member where userid = ?"; // DB에서 해당 userid에 해당하는 행(row)의 모든 열(column)을 가져오는 SQL 문. ?는 바인딩 파라미터로 나중에 PreparedStatement에서 실제 값(userid)을 넣어줌.
		
		Connection conn = null; // DB 연결
		PreparedStatement pstmt = null; // SQL 실행 준비
		ResultSet rs = null; // sql구문이 select일때만 기입!
		
		try {
			conn = getConnection(); // 오라클 DB 연결
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userid);
			rs = pstmt.executeQuery();
			
			if(rs.next()) { // 값 꺼내기
				String name = rs.getString("name");
				String id = rs.getString("userid");
				String pwd = rs.getString("pwd");
				String email = rs.getString("email");
				String phone = rs.getString("phone");
				int admin = rs.getInt("admin");
				
				mVO = new MemberVO(); // VO에 담기(저장)
				mVO.setName(name);
				mVO.setUserid(id);
				mVO.setPwd(pwd);
				mVO.setEmail(email);
				mVO.setPhone(phone);
				mVO.setAdmin(admin);
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
		return mVO;
	}

	public int confirmID(String userid) { // 아이디 중복 체크
		int result = 0;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "select userid from member where userid = ?";
		
		try {
			
			conn = getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, userid);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				result = 1; // 아이디 존재 => 사용 불가 아이디
			} else {
				result = -1; // 아이디 없음 => 사용 가능 아이디
			}
			
		} catch(Exception e) {
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
		return result;
	}
	// DB 저장
	public int insertMember(MemberVO mVO) {

		int result = -1;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String sql = "insert into member values(?, ?, ?, ?, ?, ?)";
		
		try {
			// 1. DB 연결
			conn = getConnection();
			// 2. SQL구문 전송
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mVO.getName());
			pstmt.setString(2, mVO.getUserid());
			pstmt.setString(3, mVO.getPwd());
			pstmt.setString(4, mVO.getEmail());
			pstmt.setString(5, mVO.getPhone());
			pstmt.setInt(6, mVO.getAdmin());
			
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
	}
	// 회원정보 수정
	public void updateMember(MemberVO mVO) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String sql = "update member set name=?, pwd=?, email=?, phone=?, admin=? where userid=?";
		
		try {
			// 1. DB 연결
			conn = getConnection();
			// 2. SQL구문 전송
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, mVO.getName());
			pstmt.setString(2, mVO.getPwd());
			pstmt.setString(3, mVO.getEmail());
			pstmt.setString(4, mVO.getPhone());
			pstmt.setInt(5, mVO.getAdmin());
			pstmt.setString(6, mVO.getUserid());
			
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
		} //end finally
	}
}


/*
 	String sql에서 select이 기재되어 있을 경우
 	sql 실행 부분에서는 "executeQuery"를 사용하며
 	기재 되어 있지 않을 경우 "executeUpdate"를 사용한다.
 */

package com.saeyan.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.saeyan.dto.BoardVO;

import ntil.DBManger;

public class BoardDAO {
	
	private static BoardDAO instance = new BoardDAO();
	
	private BoardDAO() {
	}
	
	public static BoardDAO getInstance() {
		return instance;
	}

	// 전체 데이터 가져오기
	public List<BoardVO> selectAllBoards() {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = "select * from board order by num desc";
		
		List<BoardVO> list = new ArrayList<BoardVO>();
		
		try {
			// 1. DB 연결
			conn = DBManger.getConnection();
			// 2. sql 전송
			pstmt = conn.prepareStatement(sql);
			// 3.spㅣ 맵핑
			// 4. sql 실행
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				BoardVO bVo = new BoardVO();
				
				bVo.setNum(rs.getInt("num"));
				bVo.setName(rs.getString("name"));
				bVo.setPass(rs.getString("pass"));
				bVo.setEmail(rs.getString("email"));
				bVo.setContent(rs.getString("content"));
				bVo.setTitle(rs.getString("title"));
				bVo.setReadCount(rs.getInt("readcount"));
				bVo.setWriteDate(rs.getTimestamp("writedate"));
				
				list.add(bVo);	
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManger.close(conn, pstmt, rs);
		}

		return list;
	}
	// 데이터 추가하기(return 불필요)
	public void insertBoard(BoardVO bVo) {

		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String sql = "insert into board(num, name, pass, email, title, content) values(board_seq.nextval ,?,?,?,?,?)";
		
		List<BoardVO> list = new ArrayList<BoardVO>();
		
		try {
			// 1. DB 연결
			conn = DBManger.getConnection();
			// 2. sql 전송
			pstmt = conn.prepareStatement(sql);
			// 3.spㅣ 맵핑
			pstmt.setString(1, bVo.getName());
			pstmt.setString(2, bVo.getPass());
			pstmt.setString(3, bVo.getEmail());
			pstmt.setString(4, bVo.getTitle());
			pstmt.setString(5, bVo.getContent());
			// 4. sql 실행
			pstmt.executeUpdate();
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManger.close(conn, pstmt);
		}
		
	} // insertBoard 끝
	
	// 단건 데이터 가져오기
	public BoardVO selectOneBoardByNum(int num) {

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "select * from board where num = ?";
		
		BoardVO bVo = new BoardVO();
		
		try {
			// 1. DB 연결
			conn = DBManger.getConnection();
			// 2. sql 전송
			pstmt = conn.prepareStatement(sql);
			// 3.spㅣ 맵핑
			pstmt.setInt(1, num);
			// 4. sql 실행
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				
				bVo.setNum(rs.getInt("num"));
				bVo.setName(rs.getString("name"));
				bVo.setPass(rs.getString("pass"));
				bVo.setEmail(rs.getString("email"));
				bVo.setContent(rs.getString("content"));
				bVo.setTitle(rs.getString("title"));
				bVo.setReadCount(rs.getInt("readcount"));
				bVo.setWriteDate(rs.getTimestamp("writedate"));	
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManger.close(conn, pstmt, rs);
		}
		return bVo; // selectOneBoardByNum 메서드에 전달한다
	} // selectOneBoardByNum 끝

	// 조회수 증가
	public void updateReadCount(int num) {

		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String sql = "update board set readcount =  readcount+1 where num = ?";
		
		try {
			// 1. DB 연결
			conn = DBManger.getConnection();
			// 2. sql 전송
			pstmt = conn.prepareStatement(sql);
			// 3.spㅣ 맵핑
			pstmt.setInt(1, num);
			// 4. sql 실행
			pstmt.executeUpdate();
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManger.close(conn, pstmt);
		}
	} // updateReadCount 끝
	
	// 데이터 삭제하기
	public void deleteBoard(int num) {

		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String sql = "delete from board where num = ?";
		
		try {
			// 1. DB 연결
			conn = DBManger.getConnection();
			// 2. sql 전송
			pstmt = conn.prepareStatement(sql);
			// 3.spㅣ 맵핑
			pstmt.setInt(1, num);
			// 4. sql 실행
			pstmt.executeUpdate();
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManger.close(conn, pstmt);
		}
	} // deleteBoard 끝

	// 데이터 수정하기
	public void updateBoard(BoardVO bVo) {

		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String sql = "update board set name=?, pass=?, email=?, title=?, content=? where num=?";
		
		try {
			// 1. DB 연결
			conn = DBManger.getConnection();
			// 2. sql 전송
			pstmt = conn.prepareStatement(sql);
			// 3.spㅣ 맵핑
			pstmt.setString(1, bVo.getName());
			pstmt.setString(2, bVo.getPass());
			pstmt.setString(3, bVo.getEmail());
			pstmt.setString(4, bVo.getTitle());
			pstmt.setString(5, bVo.getContent());
			pstmt.setInt(6, bVo.getNum());
			// 4. sql 실행
			pstmt.executeUpdate();
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}finally {
			DBManger.close(conn, pstmt);
		}
	} // updateBoard 끝

}
